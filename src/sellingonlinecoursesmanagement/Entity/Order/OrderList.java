package sellingonlinecoursesmanagement.Entity.Order;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderList {
    private List<Order> orderList;

    public OrderList() {
        this.orderList = new ArrayList<>();
    }

    // Ham tao ID ngau nhien
    public String randomOrderID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();

        while (true) {
            for (int i = 0; i < 6; i++) {
                int j = rand.nextInt(10);
                id.append(j);
            }

            boolean check = orderList.stream().noneMatch(order -> order.getOrderId().equals(id.toString()));
            if (check) return id.toString();

            id.setLength(0);
        }
    }


    // Tao don hang moi
    public void createOrder(String customerName) {
        String orderID = randomOrderID();
        Order order = new Order(orderID, customerName);
        orderList.add(order);
    }


    // Xoa 1 don hang
    public void cancelOrder(String orderID) {
        Iterator<Order> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId().equals(orderID)) {
                iterator.remove();
                System.out.println("Order with ID " + orderID + " has been canceled.");
                return;
            }
        }
        System.out.println("Order with ID " + orderID + " does not exist.");
    }


    // Search for an order by orderID - dung de hien thi order
    public void searchOrder(String orderID) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderID)) {
                order.displayOrder(orderID);
                return;
            }
        }
        System.out.println("Order with ID " + orderID + " does not exist.");
    }


    // Calculate the total cost of courses in the order
    private void calCost(Order order) {
        double totalCost = 0.0;
        for (Course course : order.getCourses()) {
            totalCost += course.getPrice();
        }
        order.setCost(totalCost);
    }


    // Lay danh sach don hang
    public List<Order> getOrderList() {
        return orderList;
    }


    //tra ve order khi nhap bang id - dung de update order
    public Order getOrderById(String orderId) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
}
