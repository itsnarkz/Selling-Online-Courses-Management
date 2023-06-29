package sellingonlinecoursesmanagement.Entity.Order;

import java.util.Scanner;

public class OrderManagementTest {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        OrderFileSystem orderFileSystem = new OrderFileSystem(orderList);
        OrderService orderService = new OrderService();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("--------- Order Management ---------");
            System.out.println("1. Create Order");
            System.out.println("2. Update Order");
            System.out.println("3. Cancel Order");
            System.out.println("4. Search Order");
            System.out.println("5. List Orders");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    orderService.createOrder();
                    break;
                case 2:
                    orderService.updateOrder();
                    break;
                case 3:
                    orderService.cancelOrder();
                    break;
                case 4:
                    orderService.searchOrder();
                    break;
                case 5:
                    orderService.listOrder();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}
