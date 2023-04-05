package com.example.demo6.SetClass;

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

        set.add(new Student(1, "Hassan"));
        set.add(new Student(1, "Hoo"));

        set.add(new Student(2, "Mike"));
        set.add(new Student(3, "Julie"));

        set.display();
        System.out.println();

        set.remove(2);

        set.display();

        System.out.println(set.peek(1));
        System.out.println(set.peek(99));

        System.out.println(set.size());

        SetClass<Student> newSet = new SetClass<>();

        newSet.add(new Student(1, "Mona"));
        newSet.add(new Student(2, "Hill"));

        System.out.println(set.equals(newSet));

        set.display();
        newSet.display();

    }
}
