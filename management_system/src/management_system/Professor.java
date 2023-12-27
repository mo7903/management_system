package management_system;

import java.util.ArrayList;

public class Professor extends User {
    public static ArrayList<Professor> UniversityProfessors = new ArrayList<Professor>();
    
    String dept;
    // Later, will be adjusted to a list of Course Objects
    ArrayList<Course> currentCourses = new ArrayList<Course>();

    public Professor(String name, String id, String dept) {
        super(name, id);
        this.dept = dept;
        appendProfessor();
    }
    public Professor(String name, String id, String dept, ArrayList<Course> currentCourses) {
        super(name, id);
        this.dept = dept;
        this.currentCourses = currentCourses;
        appendProfessor();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void addCourse(Course course) {
        this.currentCourses.add(course);
        course.getProfessors().add(this);
    }

    public void dropCourse(Course course) {
        this.currentCourses.remove(course);
        course.removeProfessor(this);
    }

    public void clearCourses() {
        for(Course c:currentCourses){
            c.getProfessors().remove(this);
        }
        this.currentCourses.clear();
    }

    public void displayCourses() {
        System.out.println("Professor " + this.name + " teaches: " + this.currentCourses);
    }

    @Override
    public String toString() {
        return "Professor {" +
                "\nname = '" + name + '\'' +
                ", \nid = '" + id + '\'' +
                ", \ndept = '" + dept + '\'' +
                ", \ncurrent_courses = " + currentCourses +
                '}';
    }
    
    private void appendProfessor(){
        UniversityProfessors.add(this);
    }
    
    public static void removeProfessor(Professor p){
        UniversityProfessors.remove(p);
    }
// Mini-Test
    
    public static void main(String[] args) {
        Professor fares = new Professor("Ahmed Fares", "1", "CSE");
        System.out.println(fares);
        Course CO = new Course("Computer Organization", "CSE321");
        Course ItoP = new Course("Intro to Programming", "CSE211");
        fares.addCourse(CO);
        fares.addCourse(ItoP);
        fares.displayCourses();
        System.out.println(CO);
        fares.dropCourse(CO);
        System.out.println(fares);
        fares.displayCourses();
        ItoP.displayCourseInfo();
    }

}
