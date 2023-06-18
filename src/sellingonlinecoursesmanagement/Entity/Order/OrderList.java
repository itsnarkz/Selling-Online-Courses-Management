package sellingonlinecoursesmanagement.Entity.Order;

import Entity.course.Course;
import Entity.course.CourseList;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class OrderList {
    private List<Order> orderList;

    public OrderList() {
        this.orderList = new ArrayList<>();
    }

    //ham random orderID
    private int randomOrderID() {
        Random random = new Random();
        return random.nextInt(900000) + 100000;
    }

    //ham tao 1 order moi
    public void createOrder(String customerName) {
        int orderID = randomOrderID();
        Order order = new Order(String.valueOf(orderID), customerName);
        orderList.add(order);
    }


    //ham huy 1 don hang trong list don hang
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


    // Search order by orderID
    public void searchOrder(String orderID) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderID)) {
                order.displayOrder(orderID);
                return;
            }
        }
        System.out.println("Order with ID " + orderID + " does not exist.");
    }

    // List of all order
    public void listOrder() {
        System.out.println("Order List:");
        System.out.println("------------------------------------------------------");
        System.out.println("| OrderID  | CustomerName   | Date         | Cost  | Status  |");
        System.out.println("------------------------------------------------------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Order order : orderList) {
            System.out.format("| %-8s | %-14s | %-12s | %-5.2f | %-7s |\n",
                    order.getOrderId(), order.getCustomerName(), order.getOrderDate().format(formatter),
                    order.getCost(), order.getStatus());
        }

        System.out.println("------------------------------------------------------");
    }

    // purchase Order
    public void purchaseHistory() {
        System.out.println("Purchase History:");
        System.out.println("------------------------------------------------------");
        System.out.println("| OrderID  | CustomerName   | Date         | Cost  | Status  |");
        System.out.println("------------------------------------------------------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Order order : orderList) {
            if (order.getStatus().equalsIgnoreCase("finish")) {
                System.out.format("| %-8s | %-14s | %-12s | %-5.2f | %-7s |\n",
                        order.getOrderId(), order.getCustomerName(), order.getOrderDate().format(formatter),
                        order.getCost(), order.getStatus());
            }
        }

        System.out.println("------------------------------------------------------");
    }



}
