package sellingonlinecoursesmanagement.App;

import sellingonlinecoursesmanagement.Entity.Course.CourseService;
import sellingonlinecoursesmanagement.Entity.Order.OrderService;

public class AdminFeatures {

    private CourseService cs;
    private OrderService os;

    public AdminFeatures() {
        this.cs = new CourseService();
        this.os = new OrderService();
    }

    public void showMenu() {
        System.out.println("--------------MENU----------");
        System.out.printf("1. ViewAllCourses           9. SearchByName");
        System.out.printf("2. ListByCategory           10. SortByPrice");
        System.out.printf("3. ListByMajor                 11. SortByName");
        System.out.printf("4. ListByBestSeller          12. ViewOrder");
        System.out.printf("5. SearchByAuthor          13. ApplyVoucher");
        System.out.printf("6. SortByRating               14. DeleteCourse");
        System.out.printf("7. SearchOrder                15. CreateCourse");
        System.out.printf("8.UpdateCourse");
    }

    public void viewAllCourses() {
        cs.viewAllCourses();
    }

    public void listByCategory() {
        cs.listByCategory();
    }

    public void listByMajor() {
        cs.listByMajor();
    }

    public void listByBestSeller() {
        cs.listBestSeller();
    }

    public void searchByAuthor() {
        cs.searchByAuthor();
    }

    public void sortByRating() {
        cs.sortByRating();
    }

    public void searchByName() {
        cs.searchByName();
    }

    public void sortByPrice() {
        cs.sortByPrice();
    }

    public void sortByName() {
        cs.sortByName();
    }

    public void viewOrder() {
        os.listOrder();
    }

    public void applyVoucher() {
        //chua co
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
}