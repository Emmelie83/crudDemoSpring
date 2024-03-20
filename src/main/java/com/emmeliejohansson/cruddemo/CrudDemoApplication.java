package com.emmeliejohansson.cruddemo;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.emmeliejohansson.cruddemo.dao.StudentDAO;
import com.emmeliejohansson.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            queryForStudents(studentDAO);
        };
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
        studentDAO.save(tempStudent);
        int theId = tempStudent.getId();
        Student myStudent = studentDAO.findById(theId);
        System.out.println("Found the student: " + myStudent);
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
