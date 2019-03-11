package com.jubayir.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking extends JpaRepository<Booking, Long> {

}
