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
                System.out.println("Invalid input!");
                System.out.print("Please enter again: ");
            }
        }

        return option;
    }

    public int Login() {
        while(true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Username (type 0 if you want to go back): ");
            String username = scanner.nextLine();
            if(Objects.equals(username, "0")) return -1;

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
        if(Objects.equals(newUsername, "0")) return;

        System.out.print("Enter a password: ");
        String newPassword = scanner.nextLine();
        String role = "user";
        loginSystem.addUser(newUsername, newPassword, role);
        System.out.println("User signed up successfully.");
    }

    public void runAdmin() {

    }

    public void runCustomer() {

    }
}
