package sellingonlinecoursesmanagement.App;

import sellingonlinecoursesmanagement.Entity.Course.Course;
import sellingonlinecoursesmanagement.Entity.Course.CourseService;
import sellingonlinecoursesmanagement.Entity.Order.OrderService;

public class CustomerFeatures {
    private CourseService cs;
    private OrderService os;

    public CustomerFeatures() {
        this.cs = new CourseService();
        this.os=new OrderService();
    }
    public void showMenu(){
        System.out.println("--------------MENU----------");
        System.out.println( "1. ViewAllCourses           7. SearchByName");
        System.out.println( "2. ListByCategory           8. SortByPrice");
        System.out.println("3. ListByMajor                  9. SortByName");
        System.out.println("4. ListByBestSeller          10. ViewOrder");
        System.out.println("5. SearchByAuthor           11. ApplyVoucher");
        System.out.println("6. SortByRating");
    }

    public void viewAllCourses(){
        cs.viewAllCourses();
    }
    public void listByCategory(){
        cs.listByCategory();
    }
    public void listByMajor(){
        cs.listByMajor();
    }
    public void listByBestSeller(){
        cs.listBestSeller();
    }
    public void searchByAuthor(){
        cs.searchByAuthor();
    }
    public void sortByRating(){
        cs.sortByRating();
    }
    public void searchByName(){
        cs.searchByName();
    }
    public void sortByPrice(){
        cs.sortByPrice();
    }
    public void sortByName(){
        cs.sortByName();
    }
    public void viewOrder(){
        os.listOrder();
    }
    public void applyVoucher(){
        //chua co  
    }

}