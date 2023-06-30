package sellingonlinecoursesmanagement.Entity.Order;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseFileSystem;
import sellingonlinecoursesmanagement.Entity.Course.CourseList;
import sellingonlinecoursesmanagement.Entity.Order.OrderList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class OrderService {
    private OrderList orderList;
    private CourseList courseList;
    private OrderFileSystem orderFileSystem;
    private CourseFileSystem courseFileSystem;

    public OrderService() {
        this.orderFileSystem = new OrderFileSystem();
        this.courseFileSystem = new CourseFileSystem();

        this.courseList = courseFileSystem.getAllCourses();
        this.orderList = orderFileSystem.getAllOrders();
    }
    //------------------------------------------------------------------
    //ham xem id co hop le khong
    private boolean validID(String id) {
        if (id.length() != 6) return false;
        for (int i = 0; i < 6; ++i)
            if (id.charAt(i) > '9' || id.charAt(i) < '0') return false;
        return true;
    }

    //ham nhap id
    private String inputID() {
        Scanner sc = new Scanner(System.in);

        String id;
        do {
            id = sc.nextLine().trim();
            if (!validID(id)) System.out.print("Invalid input! Please enter again: ");
        } while (!validID(id));

        return id;
    }

    // ham nhap course boi id
    public Course inputCourse() {
        System.out.print("Enter course ID: ");
        String courseId = inputID();

        Course course = courseList.searchByID(courseId);
        if(course == null) {
            System.out.println("Course not found by ID you had entered: " + courseId);
            return null;
        }

        return course;
    }


    //ham nhap date
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

    private String randomID() {
        Random rand = new Random();
        char[] num = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        while (true) {
            String id = "";
            for (int i = 1; i <= 6; ++i) {
                int j = rand.nextInt(10);
                id = id + num[j];
            }

            boolean check = false;
            Course target = courseList.searchByID(id);
            if (target != null) check = true;

            if (!check) return id;
        }
    }
    //------------------------------------------------------------------

    //ham tao order moi trong list order
    public void createOrder() {
        System.out.print("Enter customer name: ");
        Scanner scanner = new Scanner(System.in);

        String customerName = scanner.nextLine();
        String orderID = randomID();
        orderList.createOrder(orderID, customerName);

        orderFileSystem.createOrder(orderID, customerName);

        System.out.println("Order created successfully.");
    }

    //ham update order

    public void updateOrder() {
        System.out.print("Enter the order ID to update: ");
        String orderId = inputID();

        Order order = orderList.getOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found by the entered ID: " + orderId);
            return;
        }

        System.out.println("Select an option:");
        System.out.println("1. Add Course");
        System.out.println("2. Remove Course");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:  // them khoa hoc
                Course courseToAdd = inputCourse();
                if (courseToAdd != null) {
                    order.addCourse(courseToAdd.getId(), courseList);
                    orderFileSystem.addCourse(orderId, courseToAdd.getId(), courseList);

                    System.out.println("Course added to the order.");
                }
                break;
            case 2:  // xoa khoa hoc
                Course courseToRemove = inputCourse();
                if (courseToRemove != null) {
                    order.removeCourse(courseToRemove.getId(), courseList);
                    orderFileSystem.deleteCourse(orderId, courseToRemove.getId(), courseList);

                    System.out.println("Course removed from the order.");
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }



    //ham huy order khoi list order
    public void cancelOrder() {
        System.out.print("Enter order ID to cancel: ");
        String orderId = inputID();

        orderList.cancelOrder(orderId);
        orderFileSystem.cancelOrder(orderId);
    }

    //ham tim kiem va hien thi 1 order
    public void searchOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the order ID to search: ");
        String orderId = scanner.nextLine();

        Order target = orderList.searchOrder(orderId);
        if(target != null) target.displayOrder();
        else System.out.println("There is no order with id " + orderId + "!");
    }

    // ham in ra danh sach order
    public void listOrder() {
        System.out.println("List of Orders:");
        System.out.println("------------------------------------------------------");
        System.out.println("| OrderID  | CustomerName   | Date         | Cost  |");
        System.out.println("------------------------------------------------------");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Order order : orderList.getOrderList()) {
            System.out.format("| %-8s | %-14s | %-12s | %-7s |\n",
                    order.getOrderId(), order.getCustomerName(), order.getOrderDate().format(formatter),
                    order.getCost());
        }

        System.out.println("------------------------------------------------------");
    }
}
