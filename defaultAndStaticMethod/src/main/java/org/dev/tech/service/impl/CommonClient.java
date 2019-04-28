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
