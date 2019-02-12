package com.jubayir.exampleofcrudeoperation.repository;

import com.jubayir.exampleofcrudeoperation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
