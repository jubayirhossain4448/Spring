package com.jubayir.hotelbooking.repository;

import com.jubayir.hotelbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {

    Optional<Room> findById(Long id);
    Optional<Room> findByRoomNumber(String roomNumber);
    List<Room> findAllById();
}
