package com.example.demo6.SetClass;

import java.util.Scanner;

/***............................................................
 Project Phase 2 , SOEN 6441
 ©Faraaz, Himangshu, Shivesh
 Written by: Himangshu Shekhar Baruah , Student ID 40229774
 Ahmad Faraaz Jafri, Student ID 40232742
 Shivesh Chaudhary, Student ID 40228107

 ............................................................
 ***/
public class Driver {
    public static void main(String[] args) {
        SetClass<Student> set = new SetClass<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Peek a student");
            System.out.println("4. Display the set");
            System.out.println("5. Get size of the set");
            System.out.println("6. Create a new set and check equality");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the id of the student:");
                    int id = scanner.nextInt();
                    System.out.println("Enter the name of the student:");
                    String name = scanner.next();
                    set.add(new Student(id, name));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.println("Enter the id of the student to be removed:");
                    int removeId = scanner.nextInt();
                    Student removed = set.remove(removeId);
                    if (removed!=null) {
                        System.out.println("Student removed successfully:  "+ removed);
                    } else {
                        System.out.println("No student with that id exists in the set.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the id of the student to be peeked:");
                    int peekId = scanner.nextInt();
                    boolean peekedStudent = set.peek(peekId);
                    if (peekedStudent) {
                        System.out.println("The student is present.");
                    } else {
                        System.out.println("No student with that id exists in the set.");
                    }
                    break;

                case 4:
                    set.display();
                    break;

                case 5:
                    System.out.println("The size of the set is " + set.size());
                    break;

                case 6:
                    SetClass<Student> newSet = new SetClass<>();
                    System.out.println("Enter the number of students you want to add to the new set:");
                    int numStudents = scanner.nextInt();
                    for (int i = 1; i <= numStudents; i++) {
                        System.out.println("Enter the id of student " + i + ":");
                        int newId = scanner.nextInt();
                        System.out.println("Enter the name of student " + i + ":");
                        String newName = scanner.next();
                        newSet.add(new Student(newId, newName));
                    }
                    if (set.equals(newSet)) {
                        System.out.println("The two sets are equal!");
                    } else {
                        System.out.println("The two sets are not equal!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }
}
