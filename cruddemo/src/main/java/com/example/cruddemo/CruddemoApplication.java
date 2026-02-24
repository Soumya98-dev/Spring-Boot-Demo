package com.example.cruddemo;

import com.example.cruddemo.entity.Student;
import com.example.cruddemo.entity.student.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return args -> {
//			createStudent(studentDAO);
//			findStudent(studentDAO);
			queryForStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		Student tempStudent = new Student("Deep","C","deep@c.com");
		studentDAO.save(tempStudent);
	}

	//Finding by 'id'
	private void findStudent(StudentDAO studentDAO){
		Student foundStudent = studentDAO.findById(1);
		System.out.println(foundStudent);
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> students = studentDAO.findAll();

		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}

}
