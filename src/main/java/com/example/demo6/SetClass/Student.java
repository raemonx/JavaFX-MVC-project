package com.example.demo6.SetClass;

/***............................................................
 Project Phase 2 , SOEN 6441
 ©Faraaz, Himangshu, Shivesh
 Written by: Himangshu Shekhar Baruah , Student ID 40229774
 Ahmad Faraaz Jafri, Student ID 40232742
 Shivesh Chaudhary, Student ID 40228107

 ............................................................
 ***/
public class Student implements Identifiable {

        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int getID() {
            return id;
        }

        @Override
        public String toString() {
            return "Student details:" +
                    "id->" + id +
                    ", name->'" + name + '\'';
        }
    }


