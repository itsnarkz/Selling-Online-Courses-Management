package sellingonlinecoursesmanagement.Entity.Person.Customer;

import sellingonlinecoursesmanagement.Entity.Person.Person;

public class Customer extends Person {
    private String voucher;

    public Customer() {
    }

    public Customer(String personID, String name, int age, String gender, String phoneNumber, String email, String voucher) {
        super(personID, name, age, gender, phoneNumber, email);
        this.voucher = voucher;
    }
}
