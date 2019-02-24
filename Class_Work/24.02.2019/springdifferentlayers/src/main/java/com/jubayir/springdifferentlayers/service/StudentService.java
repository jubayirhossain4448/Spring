package com.jubayir.springdifferentlayers.service;

import com.jubayir.springdifferentlayers.entity.Student;

import java.util.List;

public interface StudentService {

    void saveOrUpdate(Student student);

    void deleteById(Long id);

    Student findById(Long id);

    Student findByEmailAddress(String email);

    List<Student> getAll();


}
