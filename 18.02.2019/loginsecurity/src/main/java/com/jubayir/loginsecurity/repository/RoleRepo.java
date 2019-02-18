package com.jubayir.loginsecurity.repository;

import com.jubayir.loginsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
