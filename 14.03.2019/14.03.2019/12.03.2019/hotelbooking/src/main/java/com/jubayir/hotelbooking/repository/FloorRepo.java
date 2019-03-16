package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepo extends JpaRepository<Floor, Long> {
}
