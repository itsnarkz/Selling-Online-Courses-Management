package sellingonlinecoursesmanagement.App;

import java.util.Objects;
import java.util.Scanner;

public class App {
    private AdminFeatures adminFeatures;
    private CustomerFeatures customerFeatures;
    private LoginSystem loginSystem;

    public App() {
        this.adminFeatures = new AdminFeatures();
        this.customerFeatures = new CustomerFeatures();
        this.loginSystem = new LoginSystem();
    }

    public void displayInfo() {
        System.out.println();
        System.out.println("            SELLING ONLINE COURSES MANAGEMENT");
        System.out.println("               ASSIGNMENT PRO192 - SE1819");
        System.out.println("                    App version 1.0");
        System.out.println("              (Please read file readme.md)");
        System.out.println();
    }

    public void displayMenu() {
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public int getChoice(int min, int max) { //must have validation
        Scanner sc = new Scanner(System.in);

        int option = -1;
        while (true) {
            try {
                option = sc.nextInt();
                if (option > max || option < min) {
                    System.out.println("Invalid input!");
                    System.out.print("Please enter again: ");
                } else break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid input!");
                System.out.print("Please enter again: ");
            }
        }

        return option;
    }

    public int Login() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Username (type 0 if you want to go back): ");
            String username = scanner.nextLine();
            if (Objects.equals(username, "0")) return -1;

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (loginSystem.login(username, password)) {
                System.out.println("Login successful.");
                if (loginSystem.hasPermission(username, "admin")) {
                    System.out.println("You are running as admin");
                    return 1;
                } else {
                    System.out.println("You are running as user");
                    return 2;
                }
            } else {
                System.out.println("Login failed. Invalid username or password.");
            }
        }
    }

    public void Signup() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a username (type 0 if you want to go back): ");
        String newUsername = scanner.nextLine();
        if (Objects.equals(newUsername, "0")) return;

        System.out.print("Enter a password: ");
        String newPassword = scanner.nextLine();
        String role = "user";
        loginSystem.addUser(newUsername, newPassword, role);
        System.out.println("User signed up successfully.");
    }

    public void runAdmin() {
        while (true) {
            adminFeatures.showMenu();
            int choice = this.getChoice(1, 15);
            System.out.println();
            switch (choice) {
                case 1:
                    adminFeatures.createCourse();
                    System.out.println();
                    break;
                case 2:
                    adminFeatures.updateCourse();
                    System.out.println();
                    break;
                case 3:
                    adminFeatures.deleteCourse();
                    System.out.println();
                    break;
                case 4:
                    adminFeatures.searchCourse();
                    System.out.println();
                    break;
                case 5:
                    adminFeatures.viewAllCourses();
                    System.out.println();
                    break;
                case 6:
                    adminFeatures.createOrder();
                    System.out.println();
                    break;
                case 7:
                    adminFeatures.updateOrder();
                    System.out.println();
                    break;
                case 8:
                    adminFeatures.cancelOrder();
                    System.out.println();
                    break;
                case 9:
                    adminFeatures.searchOrder();
                    System.out.println();
                    break;
                case 10:
                    adminFeatures.listOrder();
                    System.out.println();
                    break;
                case 11:
                    adminFeatures.createCustomer();
                    System.out.println();
                    break;
                case 12:
                    adminFeatures.updateCustomer();
                    System.out.println();
                    break;
                case 13:
                    adminFeatures.deleteCustomer();
                    System.out.println();
                    break;
                case 14:
                    adminFeatures.searchCustomer();
                    System.out.println();
                    break;
                case 15:
                    adminFeatures.viewAllCustomer();
                    System.out.println();
                    break;
                case 16:
                    System.out.println("Have a nice day!");
                    return;
            }
        }
    }

    public void runCustomer() {
        while (true) {
            customerFeatures.showMenu();
            int choice = this.getChoice(1, 14);

            System.out.println();
            switch (choice) {
                case 1:
                    customerFeatures.viewAllCourses();
                    System.out.println();
                    break;
                case 2:
                    customerFeatures.listByCategory();
                    System.out.println();
                    break;
                case 3:
                    customerFeatures.listByMajor();
                    System.out.println();
                    break;
                case 4:
                    customerFeatures.listByBestSeller();
                    System.out.println();
                    break;
                case 5:
                    customerFeatures.searchByAuthor();
                    System.out.println();
                    break;
                case 6:
                    customerFeatures.searchByName();
                    System.out.println();
                    break;
                case 7:
                    customerFeatures.sortByRating();
                    System.out.println();
                    break;
                case 8:
                    customerFeatures.sortByPrice();
                    System.out.println();
                    break;
                case 9:
                    customerFeatures.sortByName();
                    System.out.println();
                    break;
                case 10:
                    customerFeatures.createOrder();
                    System.out.println();
                    break;
                case 11:
                    customerFeatures.updateOrder();
                    System.out.println();
                    break;
                case 12:
                    customerFeatures.checkOut();
                    System.out.println();
                    break;
                case 13:
                    System.out.println("Have a nice day!");
                    return;
            }
        }
    }
}
