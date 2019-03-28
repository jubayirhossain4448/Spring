package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    Room findByRoomNumber(String roomNumber);
    Room findByFloor(String floor);
    Room findByRoomType(String roomType);
}
