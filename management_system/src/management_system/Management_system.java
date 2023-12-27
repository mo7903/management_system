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

    public static void addUser(Scanner k) {
        System.out.println("Enter user details:");
        System.out.print("Name: ");
        String name = k.next();

        System.out.print("ID: ");
        String id = k.next();

        System.out.print("Department: ");
        String department = k.next();

        while (true) {
            System.out.println("""
        Select user type:
        1. Student
        2. Professor
        3. Abort
        """);
            int i = k.nextInt();
            if (i == 1) {
                System.out.print("Faculty: ");
                String faculty = k.next();
                System.out.print("CGPA: ");
                String cgpa = k.next();
                Student s = new Student(name, id, department, faculty, cgpa);
            } else if (i == 2) {
                Professor newP = new Professor(name, id, department);
            }
            else if (i == 3) break;
            else System.out.println("Invalid Choice");
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

            int i = k.nextInt();
            switch (i) {
                case 1 -> addUser(k);
                case 2 -> displayUsers();
                case 3 -> updateUser(k);
                case 4 -> deleteUser(k);
                case 5 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
