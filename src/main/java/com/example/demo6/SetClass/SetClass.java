package com.example.demo6.SetClass;
/***............................................................
 Project Phase 2 , SOEN 6441
 ©Faraaz, Himangshu, Shivesh
 Written by: Himangshu Shekhar Baruah , Student ID 40229774
 Ahmad Faraaz Jafri, Student ID 40232742
 Shivesh Chaudhary, Student ID 40228107

 ............................................................
 ***/

import java.util.ArrayList;
import java.util.List;

public class SetClass<S extends Identifiable> {
    private List<S> elements = new ArrayList<>();

    public void add(S newElement) {
        boolean flag = false;
        if (elements.isEmpty()) {
            elements.add(newElement);
        }
        for (S element : elements) {
            if (!(element.getID() == newElement.getID()) ) {
                flag = true;
            }

        }
        if (flag){
            elements.add(newElement);
        }
    }
    public S remove(int id) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getID() == id) {
                elements.remove(i);
                return elements.get(i);
            }
        }
        return null;
    }

    public boolean peek(int id) {
        for (S element : elements) {
            if (element.getID() == id) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return elements.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SetClass) {
            SetClass<?> Set = (SetClass<?>) obj;
            if (size() == Set.size()) {
                for (S element : elements) {
                    for (Identifiable otherElement : Set.elements){
                        if (element.getID()!=otherElement.getID()) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (S element : elements) {
            System.out.println(element);
        }
    }


    }