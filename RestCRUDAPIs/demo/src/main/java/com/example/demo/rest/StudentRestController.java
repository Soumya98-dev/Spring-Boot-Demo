package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //end point for "/api/students"
    @GetMapping("/students")
    public List<Student> students(){
        List<Student> list = new ArrayList<>();

        list.add(new Student("Soumyadeep", "Chatterjee"));
        list.add(new Student("Papia", "Chatterjee"));
        list.add(new Student("Chanchal", "Chatterjee"));

        return list;
    }
}