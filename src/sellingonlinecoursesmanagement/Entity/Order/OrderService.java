package Entity.order;

import Entity.Person.Customer;
import Entity.course.Course;
import Entity.course.CourseList;
import Entity.order.OrderList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class OrderService {
    private boolean validID(String id) {
        if (id.length() != 6) return false;
        for (int i = 0; i < 6; ++i) if (id.charAt(i) > '9' || id.charAt(i) < '0') return false;
        return true;
    }

    private String inputID() {
        Scanner sc = new Scanner(System.in);

        String id = "";
        do {
            id = sc.nextLine();
            id = id.trim();
            if (!validID(id)) System.out.print("Invalid input! Please enter again: ");
        } while (!validID(id));

        return id;
    }


    // Method to input a course ID and return the corresponding course name
    public Course inputCourse() {
        System.out.print("Enter course ID: ");
        String courseId = inputID();

        CourseList courseList = new CourseList();
        Course course = courseList.searchCourseByID(courseId);

        if (course != null) {
            System.out.println(course.getCourseName());

        } else {
            System.out.println("Course not found by ID you had entered: " + courseId);
        }

        return course;
    }


    public void createOrder() {
        OrderList orderList = new OrderList();
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
            LocalDateTime orderDate = LocalDateTime.parse(input, formatter);
            return orderDate;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter again.");
            return inputOrderDate();
        }
    }




    //cancelOrder

    public void cancelOrder() {
        OrderList orderList = new OrderList();

        System.out.print("Enter order ID to cancel: ");
        String orderId = inputID();

        orderList.cancelOrder(orderId);
    }


    //searchOrder
    public void searchOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the order ID to search: ");
        String orderId = scanner.nextLine();

        OrderList orderList = new OrderList();
        orderList.searchOrder(orderId);
    }


    //applyVoucher: hoan thien sau khi voucher duoc tao boi class Person

}
