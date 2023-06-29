package sellingonlinecoursesmanagement.Entity.Customer;

public class Customer{
    private String id;
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;


    public Customer() {
    }

    public Customer(String id, String name, int age, String gender, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //ham hien thi thong tin
    public void display() {
        System.out.printf("%5s %19s %10s %10s %15s %25s \n",this.id, this.name, this.age, this.gender, this.phoneNumber, this.email);
    }


}
