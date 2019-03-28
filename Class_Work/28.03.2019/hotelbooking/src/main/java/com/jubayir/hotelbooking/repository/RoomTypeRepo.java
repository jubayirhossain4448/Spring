package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepo extends JpaRepository<RoomType, Long> {

}
