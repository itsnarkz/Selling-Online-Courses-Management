package sellingonlinecoursesmanagement.Entity.Person.Customer;

public class Customer{
    private String voucher;

    public Customer() {
    }

    public Customer(String personID, String name, int age, String gender, String phoneNumber, String email, String voucher) {
        this.voucher = voucher;
    }
}
