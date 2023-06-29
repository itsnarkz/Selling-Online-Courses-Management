package sellingonlinecoursesmanagement.Entity.Course;

import java.io.*;
import java.util.List;
import java.util.Map;

public class CourseFileSystem {
    private static final String FILE_PATH = "courses.txt";
    private CourseList courseList;

    public CourseFileSystem() {
        this.courseList = new CourseList();
        loadCourse();
    }

    public void loadCourse() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String id = parts[0];
                String courseName = parts[1];
                String category = parts[2];
                String major = parts[3];
                String courseAuthor = parts[4];
                int sold = Integer.parseInt(parts[5]);
                double price = Double.parseDouble(parts[6]);
                double rating = Double.parseDouble(parts[7]);
                String publishedDate = parts[8];
                String lastUpdateDate = parts[9];

                courseList.createCourse(id, courseName, category, major, courseAuthor, price, publishedDate);
            }
        } catch (IOException e) {
            System.out.println("Error loading courses from file: " + e.getMessage());
        }
    }

    private void saveCourse() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            List<Course> list = courseList.listAllCourses();
            for(Course course : list) {
                writer.write(course.getId() + ":" + course.getCourseName() + ":"
                + course.getCategory() + ":" + course.getMajor() + ":" + course.getCourseAuthor()
                + ":" + course.getSold() + ":" + course.getPrice() + ":" + course.getRating()
                + ":" + course.getPublishedDate() + ":" + course.getLastUpdateDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving courses to file: " + e.getMessage());
        }
    }

    public CourseList getAllCourses() {
        return courseList;
    }

    public void addCourse(String id, String courseName, String category, String major, String courseAuthor, double price, String publishedDate) {
        courseList.createCourse(id, courseName, category, major, courseAuthor, price, publishedDate);
        saveCourse();
    }

    public void deleteCourse(String id) {
        courseList.deleteCourse(id);
        saveCourse();
    }

    public void updateCourse(String id, String name, String category, String major, String author, double price, String publishedDate) {
        courseList.updateCourse(id, name, category, major, author, price, publishedDate);
        saveCourse();
    }
}
