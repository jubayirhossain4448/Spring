package com.jubayir.hotelbooking.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roomtype")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String status;


    public RoomType() {
    }

    public RoomType(String name, String status) {
        this.name = name;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType)) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(getId(), roomType.getId()) &&
                Objects.equals(getName(), roomType.getName()) &&
                Objects.equals(getStatus(), roomType.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStatus());
    }
}
