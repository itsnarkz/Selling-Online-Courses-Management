package sellingonlinecoursesmanagement.Entity.Person.Employee;

import sellingonlinecoursesmanagement.Entity.Person.Person;

public class Employee extends Person {
    public Employee() {
    }

    public Employee(String personID, String name, int age, String gender, String phoneNumber, String email) {
        super(personID, name, age, gender, phoneNumber, email);
    }
}
