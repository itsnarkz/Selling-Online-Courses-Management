package sellingonlinecoursesmanagement.Entity.Customer;

import java.text.ParseException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class CustomerService {
    private CustomerList customerList;
    private CustomerFileSystem fileSystem;

    public CustomerService() {
        this.fileSystem = new CustomerFileSystem();
        fileSystem.loadCustomer();
        this.customerList = fileSystem.getAllCustomer();
    }

    private boolean validID(String id) {
        if(id.length() != 6) return false;
        for(int i=0;i<6;++i) if(id.charAt(i) > '9' || id.charAt(i) < '0') return false;
        return true;
    }

    private String inputID() {
        Scanner sc = new Scanner(System.in);

        String id = "";
        do {
            id = sc.nextLine();
            id.trim();
            if(!validID(id)) System.out.print("Invalid input! Please enter again: ");
        } while (!validID(id));

        return id;
    }

    private String inputInfo() {
        Scanner sc = new Scanner(System.in);

        String info = sc.nextLine();

        return info.trim().toUpperCase();
    }

    private boolean validAge(int age) {
        return (age > 0);
    }

    private int inputAge() {
        Scanner sc = new Scanner(System.in);

        int res = -1;

        do{
            try {
                res = sc.nextInt();
                if(!validAge(res)) {
                    System.out.println("Invalid input!");
                    System.out.print("Please enter an age greater than 0");
                }
            } catch(Exception e) {
                System.out.println("Invalid input!");
                System.out.print("Please enter an age greater than 0");
                sc.nextLine();
            }
        } while(!validAge(res));

        return res;
    }

    private String randomID() {
        Random rand = new Random();
        char[] num = new char[]{'0', '1', '2', '3', '4','5', '6', '7', '8', '9'};

        while(true) {
            String id = "";
            for(int i=1;i<=6;++i) {
                int j = rand.nextInt(10);
                id = id + num[j];
            }

            boolean check = false;
            Customer target = customerList.searchByID(id);
            if(target != null) check = true;

            if(!check) return id;
        }
    }



    //-------------------------------------------------
    public void createCustomer() {
        System.out.print("Enter name: ");
        String name = this.inputInfo();

        System.out.print("Enter age: ");
        int age = this.inputAge();

        System.out.print("Enter gender: ");
        String gender = this.inputInfo();

        System.out.print("Enter phone number: ");
        String phoneNumber = this.inputInfo();


        System.out.print("Enter email: ");
        String email = this.inputInfo();

        String id = randomID();
        customerList.createCustomer(id, name, age, gender, phoneNumber, email);
        fileSystem.addCustomer(id, name, age, gender, phoneNumber, email);
        System.out.println("Added new customer successfully!");
    }


    // --------------------
    public void deleteCustomer() {
        System.out.print("Enter id: ");
        String id = this.inputID();

        Customer target = customerList.searchByID(id);

        if(target != null) {
            customerList.deleteCustomer(id);
            fileSystem.deleteCustomer(id);
            System.out.println("Delete customer with id " + id + " successfully");
        }
        else System.out.println("There is no customer with id " + id + "!");
    }


    public void updateCustomer() {
        System.out.print("Enter id: ");
        String id = this.inputID();
        Customer target = customerList.searchByID(id);
        if(target == null) {
            System.out.println("There is no customer with ID " + id + "!");
            return;
        }

        System.out.print("Enter new name (0 if you don't want to change): ");
        String name = this.inputInfo();

        System.out.print("Enter new age (0 if you don't want to change): ");
        int age = this.inputAge();

        System.out.print("Enter new gender (0 if you don't want to change): ");
        String gender = this.inputInfo();

        System.out.print("Enter new phone number (0 if you don't want to change): ");
        String phoneNumber = this.inputInfo();

        System.out.print("Enter new email (0 if you don't want to change): ");
        String email = this.inputInfo();


        customerList.updateCustomer(id, name, age, gender, phoneNumber, email);
        fileSystem.updateCustomer(id, name, age, gender, phoneNumber, email);
        System.out.println("Update customer successfully!");
    }

    public void viewAllCustomer() {
        System.out.println("Every customer in the system:");
        customerList.display(customerList.listAllCustomer());
    }

    public void searchCustomer(){
        System.out.println("Enter ID of customer: ");
        String id = this.inputID();

        Customer target = customerList.searchByID(id);
        if(target == null) System.out.println("There is no customer with id " + id + "!");
        else {
            System.out.println("The customer with ID " + id + ": ");
            target.displayToString();
        }
    }
}
