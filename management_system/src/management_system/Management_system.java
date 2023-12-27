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

    public static void displayUsers() {

    }

    public static void updateUser(Scanner k) {

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
                case 2 -> displayUsers();
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
