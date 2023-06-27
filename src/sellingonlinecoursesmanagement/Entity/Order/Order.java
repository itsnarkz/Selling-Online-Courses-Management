package sellingonlinecoursesmanagement.Entity.Order;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private LocalDateTime orderDate;
    private List<Course> courses;
    private double cost;
    private String status;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = LocalDateTime.now();
        this.courses = new ArrayList<>();
        this.cost = 0.0;
        this.status = "In Progress";
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayOrder(String orderID) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Date: " + orderDate.format(formatter));
        System.out.println("Cost: " + cost);
        System.out.println("Status: " + status);
        System.out.println("Courses in Order:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}
