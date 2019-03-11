package com.jubayir.hotelbooking.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    private String size;

    private String roomType;

    private String floor;

    private String status;

    private long price;

    public Room() {
    }

    public Room(String roomNumber, String size, String roomType, String floor, String status, long price) {
        this.roomNumber = roomNumber;
        this.size = size;
        this.roomType = roomType;
        this.floor = floor;
        this.status = status;
        this.price = price;
    }

    public Room(Room room) {
        this.roomNumber = room.roomNumber;
        this.size = room.size;
        this.roomType = room.roomType;
        this.floor = room.floor;
        this.status = room.status;
        this.price = room.price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getPrice() == room.getPrice() &&
                Objects.equals(getId(), room.getId()) &&
                Objects.equals(getRoomNumber(), room.getRoomNumber()) &&
                Objects.equals(getSize(), room.getSize()) &&
                Objects.equals(getRoomType(), room.getRoomType()) &&
                Objects.equals(getFloor(), room.getFloor()) &&
                Objects.equals(getStatus(), room.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoomNumber(), getSize(), getRoomType(), getFloor(), getStatus(), getPrice());
    }
}
