package management_system;

import java.util.ArrayList;

public class Professor extends User {
    String dept;
    // Later, will be adjusted to a list of Course Objects
    ArrayList<String> currentCourses = new ArrayList<String>();

    public Professor(String name, String id, String dept) {
        super(name, id);
        this.dept = dept;
    }
    public Professor(String name, String id, String dept, ArrayList<String> currentCourses) {
        super(name, id);
        this.dept = dept;
        this.currentCourses = currentCourses;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void addCourse(String course) {
        this.currentCourses.add(course);
    }

    public void dropCourse(String course) {
        this.currentCourses.remove(course);
    }

    public void clearCourses() {
        this.currentCourses.clear();
    }

    public void displayCourses() {
        System.out.println("Professor " + this.name + " teaches: " + this.currentCourses);
    }

    @Override
    public String toString() {
        return "Professor {" +
                "name = '" + name + '\'' +
                ", id = '" + id + '\'' +
                ", dept = '" + dept + '\'' +
                ", current_courses = " + currentCourses +
                '}';
    }
// Mini-Test
/*
    public static void main(String[] args) {
        Professor fares = new Professor("Ahmed Fares", "1", "CSE");
        System.out.println(fares);
        fares.addCourse("Computer Organization");
        fares.addCourse("Intro to Programming");
        fares.displayCourses();
        fares.dropCourse("CO2");
        fares.displayCourses();
    }
*/
}
