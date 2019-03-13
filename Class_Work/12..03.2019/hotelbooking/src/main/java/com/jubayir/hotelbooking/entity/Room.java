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


    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "r_type_id")
    private RoomType roomType;

    private String status;

    private double pricePerDay;


    public Room() {
    }

    public Room(String roomNumber, String size, Floor floor, RoomType roomType, String status, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.size = size;
        this.floor = floor;
        this.roomType = roomType;
        this.status = status;
        this.pricePerDay = pricePerDay;
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Double.compare(room.getPricePerDay(), getPricePerDay()) == 0 &&
                Objects.equals(getId(), room.getId()) &&
                Objects.equals(getRoomNumber(), room.getRoomNumber()) &&
                Objects.equals(getSize(), room.getSize()) &&
                Objects.equals(getFloor(), room.getFloor()) &&
                Objects.equals(getRoomType(), room.getRoomType()) &&
                Objects.equals(getStatus(), room.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoomNumber(), getSize(), getFloor(), getRoomType(), getStatus(), getPricePerDay());
    }

}
