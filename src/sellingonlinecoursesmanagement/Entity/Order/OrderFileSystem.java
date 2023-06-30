package sellingonlinecoursesmanagement.Entity.Order;
import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;

public class OrderFileSystem {
    private static final String FILE_PATH = "data/order.txt";
    private OrderList orderList;

    public OrderFileSystem() {
        this.orderList = new OrderList();
        loadOrder();
    }

    public void loadOrder() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String orderId = parts[0];
                String customerName = parts[1];
                LocalDate orderDate = LocalDate.parse(parts[2]);
                double cost = Double.parseDouble(parts[3]);

                Order order = new Order(orderId, customerName, orderDate, cost);
                orderList.createOrder(orderId, customerName);
            }
        } catch (IOException e) {
            System.out.println("Error loading orders from file: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing order date: " + e.getMessage());
        }
    }

    private void saveOrder() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            List<Order> List = orderList.getOrderList();
            for (Order order : List) {
                writer.write(order.getOrderId() + ":" + order.getCustomerName() + ":"
                        + order.getOrderDate() + ":" + order.getCost() + ":");
                for(Course course : order.getCourses()) writer.write(course.getId() + ":");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving orders to file: " + e.getMessage());
        }
    }

    public void createOrder(String orderId, String customerName) {
        saveOrder();
        loadOrder();
    }

    public void addCourse(String orderId, String courseId, CourseList list) {
        saveOrder();
        loadOrder();
    }

    public void deleteCourse(String orderId, String courseId, CourseList list) {
        saveOrder();
        loadOrder();
    }

    public void cancelOrder(String orderId) {
        orderList.cancelOrder(orderId);

        saveOrder();
        loadOrder();
    }

    public OrderList getAllOrders() {
        return orderList;
    }
}