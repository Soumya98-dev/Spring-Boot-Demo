package com.example.cruddemo.entity.student;

import com.example.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
