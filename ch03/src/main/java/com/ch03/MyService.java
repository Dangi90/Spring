package com.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired
    private  MyAdvice advice;

    public void insert(String uid){
        System.out.println("핵심기능 - insert...");

        if(uid.equals("a101")){
            System.out.println("핵심기능 - uid : " +uid);
        }
    }
    public void select(){
        System.out.println("핵심기능 - select...");
    }
    public void update(){
        System.out.println("핵심기능 - update...");
    }
    public void delete(){
        System.out.println("핵심기능 - delete...");
    }

}
