package com.emmeliejohansson.cruddemo;

import com.emmeliejohansson.cruddemo.dao.StudentDAO;
import com.emmeliejohansson.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Mary", "Jones", "mary@luv2code.com");
        Student tempStudent2 = new Student("Ken", "Williams", "ken@luv2code.com");
        Student tempStudent3 = new Student("Anne", "Smith", "anne@luv2code.com");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
        studentDAO.save(tempStudent);
    }



}
