package org.dev.tech.client;

import org.dev.tech.model.Student;
import org.dev.tech.service.MyInterface;
import org.dev.tech.service.impl.MyInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

public class ClientTest1 {

    public static void main(String [] args){

        MyInterface myInterface= new MyInterfaceImpl();

        System.out.println("-------default method--------");
        List<Student> stuList= new ArrayList<>();
        stuList.add(new Student("Aditya",25));
        stuList.add(new Student("Rama",20));
        stuList.add(new Student("Shiva",30));
        stuList.add(new Student("Brmha",100));

        List<Student> students = myInterface.sortStudents(stuList);
        for (Student student:stuList) {
            System.out.println(student);
        }

        System.out.println("-------ststic method--------");

        MyInterface.greet("Aditya");

        System.out.println("-------abstract method--------");
        List<Integer> intList = new ArrayList<>();
        intList.add(1000);
        intList.add(50);
        intList.add(9000);
        intList.add(90);
        Integer maxNum = myInterface.getMaxNum(intList);
        System.out.println("Max Num"+maxNum);

    }


}
