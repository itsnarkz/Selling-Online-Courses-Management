package sellingonlinecoursesmanagement.Entity.Course;

import java.time.LocalDate;

public class Course {
    private String id;
    private String courseName;
    private String category;

    private String major;
    private String courseAuthor;
    private int sold;
    private double price;
    private double rating;
    private String publishedDate;
    private String lastUpdateDate;

    public Course(String id, String courseName, String category, String major, String courseAuthor, double price, String publishedDate) {
        this.id = id;
        this.courseName = courseName;
        this.category = category;
        this.major = major;
        this.courseAuthor = courseAuthor;
        this.sold = 0;
        this.price = price;
        this.rating = 0;
        this.publishedDate = publishedDate;
        this.lastUpdateDate = String.valueOf(LocalDate.now());
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCourseAuthor(String courseAuthor) {
        this.courseAuthor = courseAuthor;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCategory() {
        return category;
    }

    public String getCourseAuthor() {
        return courseAuthor;
    }

    public int getSold() {
        return sold;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void display() {
        System.out.printf("%15s %20s %20s %20s %15d %15.2f %15.2f %20s %20s\n", this.id, this.courseName, this.category, this.courseAuthor, this.sold, this.price, this.rating, this.publishedDate, this.lastUpdateDate);
    }
}
