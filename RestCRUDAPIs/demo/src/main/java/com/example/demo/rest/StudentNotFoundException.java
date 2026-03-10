package com.example.demo.rest;

//CUSTOM EXCEPTION CLASS

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}