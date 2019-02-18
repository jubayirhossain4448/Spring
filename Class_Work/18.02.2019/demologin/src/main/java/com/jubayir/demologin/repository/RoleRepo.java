package com.jubayir.demologin.repository;

import com.jubayir.demologin.entity.Role;
import com.jubayir.demologin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email); // to login by username or email!
}
