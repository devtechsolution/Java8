package org.dev.tech.service;

import org.dev.tech.model.Student;

import java.util.Collections;
import java.util.List;

public interface MyInterface {

    default public List<Student> sortStudents(List<Student> stuList){
        Collections.sort(stuList);
        return stuList;
    }

    static public void greet(String name){
        System.out.println("Welcome:"+ name);
    }

    public abstract Integer getMaxNum(List<Integer> intList);

    /**
     * With default keyword we can't override Object class methods with same signature.
     * If we do so it will give compile time error.
     */
    /*
    @Override
    default String toString ( ) {
        return "ClientTest1{}";
    }
    */

}
