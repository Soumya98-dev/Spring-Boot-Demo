package com.example.restapidesigndemo.rest;

import com.example.restapidesigndemo.dao.EmployeeDAO;
import com.example.restapidesigndemo.entity.Employee;
import com.example.restapidesigndemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, JsonMapper theJsonMapper){
        employeeService =  theEmployeeService;
        jsonMapper = theJsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee id not found: "+employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);//is used to force Hibernate/JPA to treat the entity as NEW, so it performs an INSERT instead of UPDATE.

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //support for patch mapping
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchByPayload){
        // * Get employee by ID
        Employee tempEmployee = employeeService.findById(employeeId);

        // * Fail if employee doesn’t exist
        if(tempEmployee == null){
            throw new RuntimeException("Employee id not found -"+employeeId);
        }

        // * Reject request if payload tries to change id
        if(patchByPayload.containsKey("id")){
            throw  new RuntimeException("Employee id cannot be present"+employeeId);
        }

        // * Merge JSON fields into the existing object
        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchByPayload);

        // * Save the updated entity
        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }
}