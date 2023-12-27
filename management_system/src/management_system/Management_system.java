/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package management_system;

import java.util.Scanner;

/**
 *
 * @author moham
 */
public class Management_system {
    public static int getUserType(Scanner k) {
        System.out.println("""
        Select user type:
        1. Student
        2. Professor
        3. Abort
        """);
        return k.nextInt();
    }

    public static void addStudent(Scanner k) {
        System.out.println("Enter Student Info:");
        System.out.print("Name: ");
        k.nextLine();
        String name = k.nextLine();

        System.out.print("ID: ");
        String id = k.next();

        k.nextLine();
        System.out.print("Department: ");
        String department = k.nextLine();

        System.out.print("Faculty: ");
        String faculty = k.nextLine();

        System.out.print("CGPA: ");
        String cgpa = k.next();
        k.nextLine();

        Student newS = new Student(name, id, department, faculty, cgpa);
        System.out.println("Successfully added " + newS.getName());
    }

    public static void addProfessor(Scanner k) {
        System.out.println("Enter Professor Info:");
        System.out.print("Name: ");
        k.nextLine();
        String name = k.nextLine();


        System.out.print("ID: ");
        String id = k.next();

        k.nextLine();
        System.out.print("Department: ");
        String department = k.next();
        k.nextLine();

        Professor newP = new Professor(name, id, department);
        System.out.println("Successfully added Prof. " + newP.getName());
    }

    public static void addUser(Scanner k) {
        int i = getUserType(k);
        if (i == 1) {
            addStudent(k);
        } else if (i == 2) {
            addProfessor(k);
        }
        else {
            System.out.println("Invalid Choice");
        }
    }

    public static void deleteUser(Scanner k) {

    }
    
    public static void displayUsers(Scanner k) {
        int i = getUserType(k);
        if (i == 1) {
            displayStudent(k);
        } else if (i == 2) {
            displayProfessor(k);
        }
        else {
            System.out.println("Invalid Choice");
        }
    }
    
    public static void displayStudent(Scanner k){
        if(Student.UniversityStudents.size() > 0){
            System.out.printf("%11s%32s%16s%16s%16s\n", "ID", "Name", "Faculty", "Department", "CGPA");
            for(Student s:Student.UniversityStudents){
                System.out.printf("%11s%32s%16s%16s%16s\n",s.id, s.name, s.faculty, s.dept, s.CGPA); 
            }
            String id;
            boolean f;
            while(true){
                System.out.print("Enter Student Id for more info (or -1 to go back): ");
                f = false;
                id = k.next();
                if(!id.equals("-1")){
                    for(Student s:Student.UniversityStudents){
                        if(s.id.equals(id)){
                            System.out.println(s);
                            f = true;
                            break;
                        }
                    }
                    if(!f) break;
                }
                else{
                    break;
                }
            }
        }
    }
    
    public static void displayProfessor(Scanner k){
        if(Professor.UniversityProfessors.size() > 0){
            System.out.format("%11s%32s%16s\n", "ID", "Name", "Department");
            for(Professor s:Professor.UniversityProfessors){
                System.out.printf("%11s%32s%16s\n",s.id,s.name,s.dept);
            }
            String id;
            boolean f;
            while(true){
                System.out.print("Enter Professor Id for more info (or -1 to go back): ");
                f = false;
                id = k.next();
                if(!id.equals("-1")){
                    for(Professor s:Professor.UniversityProfessors){
                        if(s.id.equals(id)){
                            System.out.println(s);
                            f = true;
                            break;
                        }
                    }
                    if(!f) break;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void updateUser(Scanner k) {
        int i = getUserType(k);
        if (i == 1) {
            updateStudent(k);
        } else if (i == 2) {
            updateProfessor(k);
        }
        else {
            System.out.println("Invalid Choice");
        }
    }
    
    public static void updateStudent(Scanner k){
        if(Student.UniversityStudents.size() > 0){
            String id;
            boolean f;
            int c;
            String x;
            while(true){
                System.out.print("Enter Student Id (or -1 to go back): ");
                f = false;
                id = k.next();
                if(!id.equals("-1")){
                    for(Student s:Student.UniversityStudents){
                        if(s.id.equals(id)){
                            System.out.println(s);
                            System.out.println("""
                                Select an option:
                                1. Update ID
                                2. Update Name
                                3. Update Department
                                4. Update Faculty
                                5. Update CGPA  
                                6. Add Course
                                7. Remove Course
                                8. Go back
                                """);
                            c = k.nextInt();
                            switch (c) {
                                case 1:
                                    System.out.println("Enter new ID: ");
                                    x = k.next();
                                    s.id = x;
                                    break;
                                case 2:
                                    System.out.println("Enter new Name: ");
                                    x = k.next();
                                    s.name = x;
                                    break;
                                case 3:
                                    System.out.println("Enter new Department: ");
                                    x = k.next();
                                    s.dept = x;
                                    break;
                                case 4:
                                    System.out.println("Enter new Faculty: ");
                                    x = k.next();
                                    s.faculty = x;
                                    break;
                                case 5:
                                    System.out.println("Enter new CGPA: ");
                                    x = k.next();
                                    s.CGPA = x;
                                    break;
                                case 6:
                                    Course course = new Course("_","_");
                                    System.out.println("Enter new Course Name: ");
                                    x = k.next();
                                    course.setName(x);
                                    System.out.println("Enter new Course ID: ");
                                    x = k.next();
                                    course.setId(x);
                                    s.currentCourses.add(course);
                                    System.out.println("Course Added");
                                    break;
                                case 7:
                                    System.out.println("Enter Course ID: ");
                                    x = k.next();
                                    for(Course i:s.currentCourses){
                                        if(x.equals(i.getId())){
                                            f = true;
                                            s.currentCourses.remove(i);
                                            System.out.println("Course Removed");
                                            break;
                                        }
                                    }
                                    if(!f) System.out.println("No Course with that ID found!!");
                                    break;
                                default:
                                    break;
                            }
                            f = true;
                            break;
                        }
                    }
                    if(!f) break;
                }
                else{
                    break;
                }
            }
        }
    }
    
    public static void updateProfessor(Scanner k){
        if(Professor.UniversityProfessors.size() > 0){
            String id;
            boolean f;
            int c;
            String x;
            while(true){
                System.out.print("Enter Professor Id (or -1 to go back): ");
                f = false;
                id = k.next();
                if(!id.equals("-1")){
                    for(Professor s:Professor.UniversityProfessors){
                        if(s.id.equals(id)){
                            System.out.println(s);
                            System.out.println("""
                                Select an option:
                                1. Update ID
                                2. Update Name
                                3. Update Department
                                4. Add Course
                                5. Remove Course
                                6. Go back
                                """);
                            c = k.nextInt();
                            switch (c) {
                                case 1:
                                    System.out.println("Enter new ID: ");
                                    x = k.next();
                                    s.id = x;
                                    break;
                                case 2:
                                    System.out.println("Enter new Name: ");
                                    x = k.next();
                                    s.name = x;
                                    break;
                                case 3:
                                    System.out.println("Enter new Department: ");
                                    x = k.next();
                                    s.dept = x;
                                    break;
                                case 4:
                                    Course course = new Course("_","_");
                                    System.out.println("Enter new Course Name: ");
                                    x = k.next();
                                    course.setName(x);
                                    System.out.println("Enter new Course ID: ");
                                    x = k.next();
                                    course.setId(x);
                                    s.addCourse(course);
                                    System.out.println("Course Added");
                                    break;
                                case 5:
                                    System.out.println("Enter Course ID: ");
                                    x = k.next();
                                    for(Course i:s.currentCourses){
                                        if(x.equals(i.getId())){
                                            f = true;
                                            s.dropCourse(i);
                                            System.out.println("Course Removed");
                                            break;
                                        }
                                    }
                                    if(!f) System.out.println("No Course with that ID found!!");
                                    break;
                                default:
                                    break;
                            }
                            f = true;
                            break;
                        }
                    }
                    if(!f) break;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Select an option:
                    1. Add User
                    2. Display Users
                    3. Update User
                    4. Delete User
                    5. Exit
                    """);
            System.out.print("Choice: ");
            int i = k.nextInt();
            switch (i) {
                case 1 -> addUser(k);
                case 2 -> displayUsers(k);
                case 3 -> updateUser(k);
                case 4 -> deleteUser(k);
                case 5 -> {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
