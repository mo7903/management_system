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
public class Course {
    private String name, id;
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Professor> professors = new ArrayList<Professor>();
    private ArrayList<User> tAs = new ArrayList<User>();
    
    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }


    public ArrayList<User> gettAs() {
        return tAs;
    }

    public void addStudent(Student s){
       students.add(s);
    }
    
    public void addProfessor(Professor s){
       professors.add(s);
    }
    
    public void removeStudent(Student s){
       students.remove(s);
    }
    
    public void removeProfessor(Professor s){
       professors.remove(s);
    }
    
    public void addTA(User s){
       tAs.add(s);
    }
    
    public void displayCourseInfo(){
        System.out.println(this);
        System.out.println("Professors: ");
        professors.forEach(e->System.out.println(e.getId() +" "+ e.getName() + " " + e.getDept()));
        System.out.println("Students: ");
        students.forEach(e->System.out.println(e.getId() +" "+ e.getName() + " " + e.getDept()));
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }

    
    
}
