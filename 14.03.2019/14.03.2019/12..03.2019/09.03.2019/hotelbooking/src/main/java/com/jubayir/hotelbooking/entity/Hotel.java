package com.jubayir.hotelbooking.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String hotelName;

    private String hotelAddress;

    private String city;

    private String url;

    public Hotel() {
    }

    public Hotel(String code, String hotelName, String hotelAddress, String city, String url) {
        this.code = code;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.city = city;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(getId(), hotel.getId()) &&
                Objects.equals(getCode(), hotel.getCode()) &&
                Objects.equals(getHotelName(), hotel.getHotelName()) &&
                Objects.equals(getHotelAddress(), hotel.getHotelAddress()) &&
                Objects.equals(getCity(), hotel.getCity()) &&
                Objects.equals(getUrl(), hotel.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getHotelName(), getHotelAddress(), getCity(), getUrl());
    }
}
