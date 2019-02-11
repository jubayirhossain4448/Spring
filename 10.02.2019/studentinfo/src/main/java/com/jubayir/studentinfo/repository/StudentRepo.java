package com.jubayir.studentinfo.repository;

import com.jubayir.studentinfo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Long> {
}
