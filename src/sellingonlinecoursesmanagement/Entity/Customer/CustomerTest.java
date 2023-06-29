package sellingonlinecoursesmanagement.Entity.Person.Customer;

import java.util.Scanner;

public class CustomerTest {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("=== Customer Management ===");
            System.out.println("1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. View All Customers");
            System.out.println("5. Search Customer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    customerService.createCustomer();
                    break;
                case 2:
                    customerService.deleteCustomer();
                    break;
                case 3:
                    customerService.updateCustomer();
                    break;
                case 4:
                    customerService.viewAllCustomer();
                    break;
                case 5:
                    customerService.searchCustomer();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        System.out.println("Program exited.");
    }
}
