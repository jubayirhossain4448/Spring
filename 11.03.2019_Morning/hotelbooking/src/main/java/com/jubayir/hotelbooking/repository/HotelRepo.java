package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {

}
