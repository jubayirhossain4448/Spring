package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
