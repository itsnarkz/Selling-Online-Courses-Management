package sellingonlinecoursesmanagement.Entity.Course;

import java.time.LocalDate;
import java.util.*;

public class CourseList {
    private List<Course> courseList;

    public CourseList() {
        this.courseList = new ArrayList<Course>();
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
            for(Course course : courseList) {
                if(Objects.equals(course.getId(), id)) {
                    check = true;
                    break;
                }
            }

            if(!check) return id;
        }
    }

    public void createCourse(String courseName, String category, String major, String courseAuthor, double cost, String publishedDate) {
        String id = randomID();
        Course newCourse = new Course(id, courseName, category, major, courseAuthor, cost, publishedDate);
        courseList.add(newCourse);
    }

    public void deleteCourse(String id) {
        Course target = null;
        for(Course course : courseList) {
            if(Objects.equals(course.getId(), id)) {
                target = course;
                break;
            }
        }

        if(target != null) courseList.remove(target);
    }

    public Course searchByID(String id) {
        Course target = null;
        for(Course course : courseList) {
            if(Objects.equals(course.getId(), id)) {
                target = course;
                break;
            }
        }

        return target;
    }

    public void updateCourse(String id, String courseName, String category, String major, String courseAuthor, double price, String publishedDate) {
        Course target = null;
        for(Course course : courseList) {
            if(Objects.equals(course.getId(), id)) {
                target = course;
                break;
            }
        }

        if(target == null) System.out.println("No course found with id " + id + "!");
        else {
            if(courseName != "0") target.setCourseName(courseName);
            if(category != "0") target.setCategory(category);
            if(major != "0") target.setMajor(major);
            if(courseAuthor != "0") target.setCourseAuthor(courseAuthor);
            if(price != 0) target.setPrice(price);
            if(publishedDate != "0") target.setPublishedDate(publishedDate);
            target.setLastUpdateDate(String.valueOf(LocalDate.now()));
        }
    }

    public List<Course> listAllCourses() {
        return this.courseList;
    }

    public List<Course> listByName(String courseName) {
        List<Course> res = new ArrayList<Course>();
        for(Course course : courseList) {
            if(Objects.equals(course.getCourseName(), courseName)) res.add(course);
        }

        return res;
    }

    public List<Course> listByAuthor(String courseAuthor) {
        List<Course> res = new ArrayList<Course>();
        for(Course course : courseList) {
            if(Objects.equals(course.getCourseAuthor(), courseAuthor)) res.add(course);
        }

        return res;
    }

    public List<Course> listByCategory(String category) {
        List<Course> res = new ArrayList<Course>();
        for(Course course : courseList) {
            if(Objects.equals(course.getCategory(), category)) res.add(course);
        }

        return res;
    }

    public List<Course> listByMajor(String major) {
        List<Course> res = new ArrayList<Course>();
        for(Course course : courseList) {
            if(Objects.equals(course.getMajor(), major)) res.add(course);
        }

        return res;
    }

    public List<Course> listBestSeller() {
        List<Course> res = new ArrayList<Course>();
        for(Course course : courseList) {
            if(course.getSold() > 100 && course.getRating() >= 4) res.add(course);
        }

        return res;
    }

    public List<Course> sortByName() {
        List<Course> sorted = courseList;
        Collections.sort(sorted, Comparator.comparing((student) -> student.getCourseName()));
        return sorted;
    }

    public List<Course> sortByPrice() {
        List<Course> sorted = courseList;
        Collections.sort(sorted, Comparator.comparing((student) -> student.getPrice()));
        Collections.reverse(sorted);
        return sorted;
    }

    public List<Course> sortByRating() {
        List<Course> sorted = courseList;
        Collections.sort(sorted, Comparator.comparing((student) -> student.getRating()));
        Collections.reverse(sorted);
        return sorted;
    }

    public void display(List<Course> list) {
        System.out.printf("%15s %20s %20s %20s %15s %15s %15s %20s %20s\n", "CourseID", "Name", "Category", "Author", "Sold", "Price", "Rating", "Published Date", "Last Update Date");
        for(Course course : list) course.display();
    }
}
