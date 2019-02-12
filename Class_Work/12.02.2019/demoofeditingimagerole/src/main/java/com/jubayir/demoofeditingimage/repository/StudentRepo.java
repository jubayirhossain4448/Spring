package com.jubayir.demoofeditingimage.repository;

import com.jubayir.demoofeditingimage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long > {

}
