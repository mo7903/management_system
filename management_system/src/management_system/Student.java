/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management_system;

import java.util.ArrayList;

/**
 *
 * @author moham
 */
public class Student extends User{
    public static ArrayList<Student>  UniversityStudents = new ArrayList<Student>();
    
    protected String faculty, dept;
    protected String CGPA;
    protected ArrayList<Course> currentCourses = new ArrayList<Course>();

    public Student(String name, String id, String dept, String faculty, String CGPA) {
        super(name, id);
        this.faculty = faculty;
        this.dept = dept;
        this.CGPA = CGPA;
        appendStudent();
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }
    
    private void appendStudent(){
        UniversityStudents.add(this);
    }
    
    public static void removeStudent(Student s){
        UniversityStudents.remove(s);
    }
    
    public void addCourse(Course c){
        currentCourses.add(c);
        c.addStudent(this);
    }
    
    public void dropCourse(Course c){
        currentCourses.remove(c);
        c.removeStudent(this);
    }

    @Override
    public String toString() {
        return "Student{\nName=" + name + "\nfaculty=" + faculty + ", \ndept=" + dept + ", \nCGPA=" + CGPA + ", \ncurrentCourses=" + currentCourses + "\n}";
    }
    
    
}
