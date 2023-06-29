package sellingonlinecoursesmanagement.Entity.Order;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;

public class OrderFileSystem {
    private static final String FILE_PATH = "order.txt";
    private OrderList orderList;

    public OrderFileSystem(OrderList orderList) {
        this.orderList = orderList;
        loadOrder();
    }

    public void loadOrder() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String orderId = parts[0];
                String customerName = parts[1];
                LocalDateTime orderDate = LocalDateTime.parse(parts[2]);
                double cost = Double.parseDouble(parts[3]);

                Order order = new Order(orderId, customerName, orderDate, cost);
                orderList.getOrderList().add(order);
            }
        } catch (IOException e) {
            System.out.println("Error loading orders from file: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing order date: " + e.getMessage());
        }
    }

    private void saveOrder() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            List<Order> orderList = this.orderList.getOrderList();
            for (Order order : orderList) {
                writer.write(order.getOrderId() + ":" + order.getCustomerName() + ":"
                        + order.getOrderDate().toString() + ":" + order.getCost());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving orders to file: " + e.getMessage());
        }
    }

    public void createOrder(String customerName) {
        String orderId = randomOrderID();
        LocalDateTime orderDate = LocalDateTime.now();
        double cost = 0.0;
        Order order = new Order(orderId, customerName, orderDate, cost);
        orderList.getOrderList().add(order);
        saveOrder();
    }

    private String randomOrderID() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Số ngẫu nhiên từ 100000 đến 999999
        return String.valueOf(randomNumber);
    }


    public void updateOrder(String orderId, OrderService orderService) {
        orderService.updateOrder();
        saveOrder();
    }


    public void searchOrder(String orderId, OrderService orderService) {
        orderService.searchOrder();
    }

    public void cancelOrder(String orderId, OrderService orderService) {
        orderService.cancelOrder();
        saveOrder();
    }

    public void listOrder(OrderService orderService) {
        orderService.listOrder();
    }

}