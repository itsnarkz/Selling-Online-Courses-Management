package sellingonlinecoursesmanagement.Entity.Order;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;
import sellingonlinecoursesmanagement.Entity.Order.OrderList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class OrderService {
    private OrderList orderList;
    private CourseList courseList;

    public OrderService() {
        this.orderList = new OrderList();
        this.courseList = new CourseList();
    }

    private boolean validID(String id) {
        if (id.length() != 6) return false;
        for (int i = 0; i < 6; ++i)
            if (id.charAt(i) > '9' || id.charAt(i) < '0') return false;
        return true;
    }

    private String inputID() {
        Scanner sc = new Scanner(System.in);

        String id;
        do {
            id = sc.nextLine().trim();
            if (!validID(id)) System.out.print("Invalid input! Please enter again: ");
        } while (!validID(id));

        return id;
    }

    // Method to input a course ID and return the corresponding course name
    public Course inputCourse() {
        System.out.print("Enter course ID: ");
        String courseId = inputID();

        Course course = courseList.searchByID(courseId);
        if (course != null) {
            System.out.println(course.getCourseName());
        } else {
            System.out.println("Course not found by ID you had entered: " + courseId);
        }

        return course;
    }

    public void createOrder() {
        String orderId = orderList.randomOrderID();
        System.out.println("Order ID: " + orderId);

        Course course = inputCourse();
        if (course != null) {
            LocalDateTime orderDate = inputOrderDate();
            orderList.createOrder(orderId, course, orderDate);
            System.out.println("Order created successfully!");
        }
    }

    private LocalDateTime inputOrderDate() {
        System.out.println("Enter order date and time (yyyy-MM-dd HH:mm): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter again.");
            return inputOrderDate();
        }
    }

    public void cancelOrder() {
        System.out.print("Enter order ID to cancel: ");
        String orderId = inputID();
        orderList.cancelOrder(orderId);
    }

    public void searchOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the order ID to search: ");
        String orderId = scanner.nextLine();
        orderList.searchOrder(orderId);
    }

    //applyVoucher: hoan thien sau khi voucher duoc tao boi class Person
}
