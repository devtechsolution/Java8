****Default and static methods in Interfaces****

    From Java 8, interfcaes are enhanced to have method with implementation. We can use default and static keyword to create interfaces with method implementation

    Java 8 uses default and static methods heavily in Collection API and default methods are added so that our code remains backward compatible.

**Overriding Methods on "Object" class methods:**

    Its not possible for an interface to provide default implementations for the methods in Object. Trying to do so will result in a compile error.
    If any clas in the hierarchy has a method with same signature as Object class methods, then default method became irrelevant. Since any class implementing 
    an interface already has Object as superclass, if we have equlas(), hashCode() default methods in interface, it will become irrelevent. That's why for 
    better clarity, interfaces are not allowed to have Object class default methods.
    
 
**Key point about static and default methods**
    1. Default methods enable us to add new functionality to the interfaces of ours liberaries and ensure binary compatibility with code 
       Written for older versions of those interfaces.
    2. Interface default method helps in extending inerfaces without having the fear of breaking implementation classes.
            For Example: **java.util.Comparator interface**
    3. Normally, static method in is used as Helper methods while default method are used as a default implementation for classes that implements that interface.
            **public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp)**
    4. default methods can be overriden in implementing class, while static can't.
    5. Both implemented class and interface can have static methods with same name, and neither overriding other.
    6. Remember in case a class is implementing more than one interfcaes with same default method signature then the implemented class 
       needs to override the default method.
 
 
**MyInterface.java**    
```$xslt
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

```
 
**MyInterfaceImpl.java**
```$xslt
    package org.dev.tech.service.impl;
    
    import org.dev.tech.service.MyInterface;
    
    import java.util.Collections;
    import java.util.List;
    
    public class MyInterfaceImpl implements MyInterface {
        @Override
        public Integer getMaxNum(List<Integer> intList) {
            Integer max = Collections.max(intList);
            return max;
        }
    }


``` 

**Student.java**
```$xslt
package org.dev.tech.model;

public class Student implements Comparable<Student> {

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


```
**ClientTest1.java**
```$xslt

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

```
**Output**
```
-------default method--------
Student{name='Aditya', age=25}
Student{name='Brmha', age=100}
Student{name='Rama', age=20}
Student{name='Shiva', age=30}
-------ststic method--------
Welcome:Aditya
-------abstract method--------
Max Num9000

```

**In case a class is implementing more than one interfcaes with same default method signature then the implemented class needs to override the default method.**

**Interface1.java**
```$xslt

package org.dev.tech.service;

public interface Interface1 {

    default public void display(){
        System.out.println("Interface1:display");
    }
}

```

**Interface2.java**
```$xslt

package org.dev.tech.service;

public interface Interface2 {

    default public void display(){
        System.out.println("Interface2:display");
    }
}

```

**CommonClient.java**
```$xslt

package org.dev.tech.service.impl;

import org.dev.tech.service.Interface1;
import org.dev.tech.service.Interface2;

public class CommonClient implements Interface1, Interface2 {
    @Override
    public void display ( ) {
        Interface1.super.display();// For calling interface implemented default method using super keyword
        Interface2.super.display();// For calling interface implemented default method using super keyword
        System.out.print("Hello"); // Override and give your own logic
    }

    public static void main(String[] args){
        CommonClient commonClient= new CommonClient();
        commonClient.display();
    }
}


```


**Output**
```$xslt
Interface1:display
Interface2:display
Hello
```