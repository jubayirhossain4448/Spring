package com.jubayir.springdifferentlayers.serviceimple;

import com.jubayir.springdifferentlayers.entity.Student;
import com.jubayir.springdifferentlayers.repository.StudentRepository;
import com.jubayir.springdifferentlayers.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;

    @Override
    public void saveOrUpdate(Student student) {

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Student findById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public Student findByEmailAddress(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Student> getAll() {
        List<Student> list =repository.findAll();

        for (Student s : list){
        }

        return null;
    }
}
