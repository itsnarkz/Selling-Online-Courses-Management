package sellingonlinecoursesmanagement.Entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerList {
    private List<Customer> customerList;

    public CustomerList() {
        this.customerList = new ArrayList<Customer>();
    }

    public void createCustomer(String id, String name, int age, String gender, String phoneNumber, String email) {
        Customer newCustomer = new Customer(id,name,age,gender,phoneNumber,email);

        boolean check = false;
        for(Customer customer : customerList) {
            if(Objects.equals(customer.getId(), id)) {
                check = true;
                break;
            }
        }

        if(!check) customerList.add(newCustomer);
    }


    public void deleteCustomer(String id) {
        Customer target = null;
        for(Customer customer : customerList) {
            if(Objects.equals(customer.getId(), id)) {
                target = customer;
                break;
            }
        }

        if(target != null) customerList.remove(target);
    }


    public Customer searchByID(String id) {
        Customer target = null;
        for (Customer customer : customerList) {
            if (Objects.equals(customer.getId(), id)) {
                target = customer;
                break;
            }
        }

        return target;
    }


    public void updateCustomer(String id, String name, int age, String gender, String phoneNumber, String email) {
        Customer target = null;
        for(Customer customer : customerList) {
            if(Objects.equals(customer.getId(), id)) {
                target = customer;
                break;
            }
        }

        if(!Objects.equals(name, "0")) target.setName(name);
        if(age != 0) target.setAge(age);
        if(!Objects.equals(gender, "0")) target.setGender(gender);
        if(!Objects.equals(phoneNumber, "0")) target.setPhoneNumber(phoneNumber);
        if(!Objects.equals(email, "0")) target.setEmail(email);
    }


    public List<Customer> listAllCustomer() {
        return this.customerList;
    }

    public void display(List<Customer> list) {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%-7s %-21s %-10s %-10s %-17s %-22s", "ID", "Name", "Age", "Gender", "Phone Number", "Email");
        System.out.println();
        for(Customer customer : list) customer.display();
        System.out.println("-------------------------------------------------------------------------------------------------");

    }

}
