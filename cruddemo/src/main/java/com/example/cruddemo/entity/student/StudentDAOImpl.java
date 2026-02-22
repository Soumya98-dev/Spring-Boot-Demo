package com.example.cruddemo.entity.student;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

}
