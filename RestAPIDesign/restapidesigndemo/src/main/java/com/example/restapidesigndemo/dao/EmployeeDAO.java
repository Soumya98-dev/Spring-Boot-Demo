package com.example.restapidesigndemo.dao;

import com.example.restapidesigndemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByID(int theID);
    Employee save(Employee theEmployee);
    void deleteById(int theID);
}