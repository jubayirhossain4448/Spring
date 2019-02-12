package com.jubayir.exampleofeditingimage.repository;

import com.jubayir.exampleofeditingimage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
