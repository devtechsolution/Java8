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
