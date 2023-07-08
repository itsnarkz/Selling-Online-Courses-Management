package sellingonlinecoursesmanagement.Entity.Order;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {
    private String orderId;
    private String customerName;
    private LocalDate orderDate;
    private List<Course> courses;
    private double cost;

    public Order(String orderId, String customerName, LocalDate orderDate, double cost) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.cost = cost;
        this.courses = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getCost() {
        return cost;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    public void addCourse(String courseId, CourseList courseList) {
        Course course = courseList.searchByID(courseId);
        courses.add(course);
        cost += course.getPrice();
    }

    public void removeCourse(String courseId, CourseList courseList) {
        Iterator<Course> iterator = courses.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId().equals(courseId)) {
                iterator.remove();
                cost -= course.getPrice();
                found = true;
                break;
            }
        }
    }

    public void displayOrder() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Date: " + orderDate.format(formatter));
        System.out.println("Cost: " + cost);
        System.out.println("Courses in Order:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}
