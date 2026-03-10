package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        //Updating REST service to throw exception if student not found
        if(studentid >= list.size() || studentid < 0){
            throw new StudentNotFoundException("Student id not found - "+studentid);
        }
        return list.get(studentid);
    }
}