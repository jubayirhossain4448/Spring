package com.jubayir.springcrudeoperation.repository;

import com.jubayir.springcrudeoperation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
