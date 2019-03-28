package com.jubayir.hotelbooking.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "floor")
public class Floor extends Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String size;

    private String note;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Floor() {
    }

    public Floor(String name, String size, String note, Hotel hotel) {
        this.name = name;
        this.size = size;
        this.note = note;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Floor)) return false;
        Floor floor = (Floor) o;
        return Objects.equals(getId(), floor.getId()) &&
                Objects.equals(getName(), floor.getName()) &&
                Objects.equals(getSize(), floor.getSize()) &&
                Objects.equals(getNote(), floor.getNote()) &&
                Objects.equals(getHotel(), floor.getHotel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSize(), getNote(), getHotel());
    }
}
