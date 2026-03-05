package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> list;

    @PostConstruct
    public void loadData(){
        list = new ArrayList<>();

        list.add(new Student("Soumyadeep", "Chatterjee"));
        list.add(new Student("Papia", "Chatterjee"));
        list.add(new Student("Chanchal", "Chatterjee"));
    }

    //end point for "/api/students"
    @GetMapping("/students")
    public List<Student> students(){
        return list;
    }

    @GetMapping("/students/{studentid}")
    public Student getStudent(@PathVariable int studentid){
        return list.get(studentid);
    }
}