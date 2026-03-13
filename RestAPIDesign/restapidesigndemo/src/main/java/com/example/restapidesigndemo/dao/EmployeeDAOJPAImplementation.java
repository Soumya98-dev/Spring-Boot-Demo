package com.example.restapidesigndemo.dao;

import com.example.restapidesigndemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImplementation implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImplementation(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    public List<Employee> findAll(){
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findByID(int theID) {
        Employee employee = entityManager.find(Employee.class, theID);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theID) {
        Employee employee = entityManager.find(Employee.class, theID);

        entityManager.remove(employee);
    }
}