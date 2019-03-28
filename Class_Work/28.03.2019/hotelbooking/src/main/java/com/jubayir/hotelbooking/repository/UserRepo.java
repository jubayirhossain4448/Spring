package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Role;
import com.jubayir.hotelbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email);
    //    Optional<User> findByUserName(String username);
    User findByUserName(String userName);
    Optional<User> findByEmail(String email);
    List<User> findAllByRoles(Set<Role> roles);
    boolean existsByEmail(String email);
    User findByConfirmationToken(String token);
    User findAllByUserName(String userName);
}
