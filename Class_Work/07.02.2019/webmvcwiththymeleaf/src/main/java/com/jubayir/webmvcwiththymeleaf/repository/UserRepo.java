package com.jubayir.webmvcwiththymeleaf.repository;

import com.jubayir.webmvcwiththymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}

