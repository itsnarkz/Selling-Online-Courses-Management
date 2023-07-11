package sellingonlinecoursesmanagement.Entity.Course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CourseService {
    private CourseList courseList;
    private CourseFileSystem fileSystem;

    public CourseService() {
        this.fileSystem = new CourseFileSystem();
        fileSystem.loadCourse();
        this.courseList = fileSystem.getAllCourses();
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

    private boolean validDate(String info) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(info);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private String inputDate() {
        Scanner sc = new Scanner(System.in);

        String info = "";

        do{
            try {
                info = sc.nextLine();
                if(!validDate(info)) {
                    System.out.println("Invalid input!");
                    System.out.print("Please enter again: ");
                }
            } catch(Exception e) {
                System.out.println("Invalid input!");
                System.out.print("Please enter again: ");
                sc.nextLine();
            }
        } while(!validDate(info.trim()));

        return info.trim().toUpperCase();
    }

    private boolean validPrice(double price) {
        return (price >= 0);
    }

    private double inputPrice() {
        Scanner sc = new Scanner(System.in);

        double res = -1;

        do{
            try {
                res = sc.nextDouble();
                if(!validPrice(res)) {
                    System.out.println("Invalid input!");
                    System.out.print("Please enter again: ");
                }
            } catch(Exception e) {
                System.out.println("Invalid input!");
                System.out.print("Please enter again: ");
                sc.nextLine();
            }
        } while(!validPrice(res));

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
            Course target = courseList.searchByID(id);
            if(target != null) check = true;

            if(!check) return id;
        }
    }

    public void createCourse() {
        System.out.print("Enter name: ");
        String courseName = this.inputInfo();

        System.out.print("Enter category: ");
        String category = this.inputInfo();

        System.out.print("Enter major: ");
        String major = this.inputInfo();

        System.out.print("Enter author: ");
        String courseAuthor = this.inputInfo();

        System.out.print("Enter price: ");
        double price = this.inputPrice();

        System.out.print("Enter published date: ");
        String publishedDate = this.inputDate();

        String id = randomID();
        courseList.createCourse(id, courseName, category, major, courseAuthor, price, publishedDate);
        fileSystem.addCourse(id, courseName, category, major, courseAuthor, price, publishedDate);

        System.out.println("Added new course successfully!");
    }

    public void deleteCourse() {
        System.out.print("Enter id: ");
        String id = this.inputID();

        Course target = courseList.searchByID(id);

        if(target != null) {
            courseList.deleteCourse(id);
            fileSystem.deleteCourse(id);
            System.out.println("Delete course with id " + id + " successfully");
        }
        else System.out.println("There is no course with id " + id + "!");
    }

    public void updateCourse() {
        System.out.print("Enter id: ");
        String id = this.inputID();
        Course target = courseList.searchByID(id);
        if(target == null) {
            System.out.println("There is no course with id " + id + "!");
            return;
        }

        System.out.print("Enter new name (0 if you don't want to change): ");
        String name = this.inputInfo();

        System.out.print("Enter new category (0 if you don't want to change): ");
        String category = this.inputInfo();

        System.out.print("Enter new major (0 if you don't want to change): ");
        String major = this.inputInfo();

        System.out.print("Enter new author (0 if you don't want to change): ");
        String author = this.inputInfo();

        System.out.print("Enter new price (0 if you don't want to change): ");
        double price = this.inputPrice();

        System.out.print("Enter new published date (0 if you don't want to change): ");
        String publishedDate = this.inputInfo();

        courseList.updateCourse(id, name, category, major, author, price, publishedDate);
        fileSystem.updateCourse(id, name, category, major, author, price, publishedDate);
        System.out.println("Update course successfully!");
    }

    public void viewAllCourses() {
        System.out.println("Every courses in the system:");
        courseList.display(courseList.listAllCourses());
    }

    public void searchById() {
        System.out.print("Enter id: ");
        String id = this.inputID();

        Course target = courseList.searchByID(id);
        if(target == null) System.out.println("There is no course with id " + id + "!");
        else {
            System.out.println("The course with id " + id + " is: ");
            List<Course> t = new ArrayList<Course>();
            t.add(courseList.searchByID(id));
            courseList.display(t);
        }
    }

    public void searchByName() {
        System.out.print("Enter the name: ");
        String name = this.inputInfo();

        System.out.println("The courses with name " + name + " are: ");
        courseList.display(courseList.listByName(name));
    }

    public void searchByAuthor() {
        System.out.print("Enter the author: ");
        String author = this.inputInfo();

        System.out.println("The courses with author " + author.trim() + " are: ");
        courseList.display(courseList.listByAuthor(author));
    }

    public void listByCategory() {
        System.out.print("Enter the category: ");
        String category = this.inputInfo();

        System.out.println("The courses with category " + category.trim() + " are: ");
        courseList.display(courseList.listByCategory(category));
    }

    public void listByMajor() {
        System.out.print("Enter the major: ");
        String major = this.inputInfo();

        System.out.println("The courses of major " + major.trim() + " are: ");
        courseList.display(courseList.listByMajor(major));
    }

    public void listBestSeller() {
        System.out.println("The best sellers: ");
        courseList.display(courseList.listBestSeller());
    }

    public void sortByName() {
        System.out.println("The courses in order of name(ascending): ");
        courseList.display(courseList.sortByName());
    }

    public void sortByPrice() {
        System.out.println("The courses in order of price(descending): ");
        courseList.display(courseList.sortByPrice());
    }

    public void sortByRating() {
        System.out.println("The courses in order of rating(descending): ");
        courseList.display(courseList.sortByRating());
    }
}
