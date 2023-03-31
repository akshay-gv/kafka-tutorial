package com.gv.kafkaproducer.Model;

import java.util.ArrayList;

public class Details {

    // Creating an object of ArrayList
    public static ArrayList<Details> Cache
            = new ArrayList<Details>();
    public String name;
    public String email;
    public String subject;
    public String message;
    public Details(String name , String email , String subject, String message)
    {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    @Override
    public String toString(){
        return name + " " + email +" "+ subject+" "+ message;
    }
}