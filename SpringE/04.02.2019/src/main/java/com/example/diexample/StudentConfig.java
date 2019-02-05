package com.example.diexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "student")
    public Student getStudent(){
         Student student = new Student(100,  "Moly Susmi Rojina");
         return student;

    }

    @Bean(name = "st")
    public Student getStudentBySetter(){
        Student student = new Student();
        student.setId(500);
        student.setName("Mr. Boys");
        return student;
    }
}
