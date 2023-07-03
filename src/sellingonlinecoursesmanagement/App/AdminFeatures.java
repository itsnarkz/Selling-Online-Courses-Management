package sellingonlinecoursesmanagement.App;

import sellingonlinecoursesmanagement.Entity.Course.CourseService;
import sellingonlinecoursesmanagement.Entity.Customer.CustomerService;
import sellingonlinecoursesmanagement.Entity.Order.OrderService;

public class AdminFeatures {

    private CourseService cs;
    private OrderService os;
    private CustomerService cus;

    public AdminFeatures() {
        this.cs = new CourseService();
        this.os = new OrderService();
        this.cus= new CustomerService();
    }

    public void showMenu() {
        System.out.println("------------------------------------MENU--------------------------------------");
        System.out.println("1. Create Course                6. Create Order             11.Create Customer");
        System.out.println("2. Update Course                7. Update Order             12.Update Customer");
        System.out.println("3. Cancel Course                8. Delete Order             13.Delete Customer");
        System.out.println("4. Search Course                9. Search Order             14.Search Customer");
        System.out.println("5. View Course                  10. View Order              15.View Customer");
        System.out.println("                                16. Exit");

    }
    public void createOrder() {
        os.createOrder();
    }
    public void updateOrder() {
        os.updateOrder();
    }
    public void cancelOrder() {
        os.cancelOrder();
    }
    public void listOrder() {
        os.listOrder();
    }

    public void createCustomer() {
        cus.createCustomer();
    }

    public void deleteCustomer() {
        cus.deleteCustomer();
    }

    public void updateCustomer() {
        cus.updateCustomer();
    }

    public void viewAllCustomer() {
        cus.viewAllCustomer();
    }
    public void searchCustomer(){
        cus.searchCustomer();
    }

    public void searchOrder() {
        os.searchOrder();

    }

    public void updateCourse() {
        cs.updateCourse();
    }

    public void createCourse() {
        cs.createCourse();
    }

    public void deleteCourse() {
        cs.deleteCourse();
    }

    public void searchCourse() {
        cs.searchById();
    }

    public void viewAllCourses() {
        cs.viewAllCourses();
    }


}