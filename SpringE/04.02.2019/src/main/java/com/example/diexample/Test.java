package com.example.diexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class); // to read a file we need to
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        Student student1 = (Student) context.getBean("st");
        System.out.println(student1);
    }
}
