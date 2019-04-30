## Fuctional Interface and Lambda Expression**

*   An interface which contains exactly one abstract method is known as a **Functional Interface**
*   Functional Interface is also known as **Single Abstract Method Interfaces or SAM Interfaces.**
*   These can be represented using **Lambda Expression**, **Method Reference** and **Constructor**.
*   Java 8 introduces **@FunctionalInterface** annotation which is used for compiler level **error** when the interface
    we annotated violates the contract of Functional Interface.
*   Few Functinal Interfaces are
    - **Runnable, Callable, Comparator, ActionListener, and others.**
*   They can be implemented and instantiated using anonymous class syntax, but the code looks bulky.
```$xslt
    Runnable r= new Runnable() {
                @Override
                public void run ( ) {
                    System.out.print("Runnable Task Executed");
                }
     };
```

*   Since the Functional interfaces have only one method, Lambda expressions can 
    easily provide the method implementation. We just need to provide arguments and
    business logic.
*   For example we can write above implementation uing Lambda Expression as:
```$xslt
    Runnable r = () -> {
        System.out.print("Runnable Task Executed");
    };
```
*   A new package **java.util.function** has been added with bunch of functional interfaces
    to provide target types for Lambda Expression and method references.

# App.java
  
```$xslt
    package org.dev.tech;
    
    /**
     * Hello world!
     *
     */
    public class App 
    {
    
    
        public static void main( String[] args )
        {
            createRunnableUsingAnonymous();
            createRunnableUsingLambda();
        }
    
        private static void createRunnableUsingLambda ( ) {
            Runnable r = () -> {System.out.print("Runnable Task Executed");};
    
            System.out.println( "Hello World!" );
            Thread thread= new Thread(r);
            thread.start();
        }
    
        private static void createRunnableUsingAnonymous ( ) {
            Runnable r= new Runnable() {
                @Override
                public void run ( ) {
                    System.out.print("Runnable Task Executed");
                }
            };
            System.out.println( "Hello World!" );
            Thread thread= new Thread(r);
            thread.start();
        }
    }

```
    