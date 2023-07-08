package sellingonlinecoursesmanagement.Entity.Order;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderList {
    private List<Order> orderList;

    public OrderList() {
        this.orderList = new ArrayList<>();
    }

    // Tao don hang moi
    public void createOrder(String orderId, String customerName) {
        LocalDate orderDate = LocalDate.now();
        double cost = 0.0;
        Order order = new Order(orderId, customerName.trim().toUpperCase(), orderDate, cost);
        orderList.add(order);
    }

    // Xoa 1 don hang
    public void cancelOrder(String orderID) {
        Iterator<Order> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId().equals(orderID)) {
                iterator.remove();
                return;
            }
        }
    }


    // Search for an order by orderID - dung de hien thi order
    public Order searchOrder(String orderID) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderID)) {
                return order;
            }
        }
        return null;
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
        return this.orderList;
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
