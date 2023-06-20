package Entity.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String orderId;
    private String customerName;
    private LocalDateTime orderDate;
    private String status;
    private double cost;

    public Order(String orderId, String customerName, LocalDateTime orderDate, String status, double cost) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.status = status;
        this.cost = cost;
    }

    public Order(String orderId, String customerName) {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    //method display
    public void displayOrder(String orderID) {
//        System.out.println("--------------------------------------------------------------------------------------------");
//        System.out.println("|                                                                                          |");
//        System.out.println("|                               Super  Vip  Pro                                            |");
//        System.out.println("|                                                                                          |");
//        System.out.println("| ---------------------------------------------------------------------------------------- |");
//        System.out.format("| Order ID: %79s|\n", orderID.getOrderId());
//        displayDate(orderID.getOrderDate());
//        System.out.format("| Name:    %80s|\n", orderID.getCustomerName());
//        System.out.format("| Status:  %80s|\n", orderID.getStatus());
//        System.out.println("| ---------------------------------------------------------------------------------------- |");
//        System.out.println("|   No  |                     Course                    |   Author   | Quantity |   Cost   |");
//        System.out.println("| ---------------------------------------------------------------------------------------- |");
//        // Print Entity.course details (dummy data for demonstration)
//        System.out.println("|   1   | Course 1                                      |  Author 1  |    2     |  $100.00 |");
//        System.out.println("|   2   | Course 2                                      |  Author 2  |    1     |  $50.00  |");
//        System.out.println("|   3   | Course 3                                      |  Author 3  |    3     |  $150.00 |");
//        // Print total cost
//        System.out.println("| ---------------------------------------------------------------------------------------- |");
//        System.out.format("| Total Cost: %-77.2f|\n", orderID.getCost());
//        System.out.println("| ---------------------------------------------------------------------------------------- |");
    }

    private void displayDate(LocalDateTime orderDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.format("| Order Date: %76s|\n", orderDate.format(formatter));
    }
}
