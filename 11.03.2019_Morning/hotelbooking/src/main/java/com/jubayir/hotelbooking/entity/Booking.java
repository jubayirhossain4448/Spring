package com.jubayir.hotelbooking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingId;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkIn;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkout;

    private int roomNumber;

    private int customerId;

    private String bookingType;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bookingTime;

    private String bookingStatus;

    private int totalDay;

    private int cost;

    private long totalCost;

    private int totalRoom;

    private int totalperson;


    public Booking() {
    }

    public Booking(String bookingId, Date arrivalDate, Date checkIn, Date checkout, int roomNumber, int customerId, String bookingType, Date bookingTime, String bookingStatus, int totalDay, int cost, long totalCost, int totalRoom, int totalperson) {
        this.bookingId = bookingId;
        this.arrivalDate = arrivalDate;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.roomNumber = roomNumber;
        this.customerId = customerId;
        this.bookingType = bookingType;
        this.bookingTime = bookingTime;
        this.bookingStatus = bookingStatus;
        this.totalDay = totalDay;
        this.cost = cost;
        this.totalCost = totalCost;
        this.totalRoom = totalRoom;
        this.totalperson = totalperson;
    }

    public Booking(Booking booking) {
        this.bookingId = booking.bookingId;
        this.arrivalDate = booking.arrivalDate;
        this.checkIn = booking.checkIn;
        this.checkout = booking.checkout;
        this.roomNumber = booking.roomNumber;
        this.customerId = booking.customerId;
        this.bookingType = booking.bookingType;
        this.bookingTime = booking.bookingTime;
        this.bookingStatus = booking.bookingStatus;
        this.totalDay = booking.totalDay;
        this.cost = booking.cost;
        this.totalCost = booking.totalCost;
        this.totalRoom = booking.totalRoom;
        this.totalperson = booking.totalperson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }

    public int getTotalperson() {
        return totalperson;
    }

    public void setTotalperson(int totalperson) {
        this.totalperson = totalperson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return getRoomNumber() == booking.getRoomNumber() &&
                getCustomerId() == booking.getCustomerId() &&
                getTotalDay() == booking.getTotalDay() &&
                getCost() == booking.getCost() &&
                getTotalCost() == booking.getTotalCost() &&
                getTotalRoom() == booking.getTotalRoom() &&
                getTotalperson() == booking.getTotalperson() &&
                Objects.equals(getId(), booking.getId()) &&
                Objects.equals(getBookingId(), booking.getBookingId()) &&
                Objects.equals(getArrivalDate(), booking.getArrivalDate()) &&
                Objects.equals(getCheckIn(), booking.getCheckIn()) &&
                Objects.equals(getCheckout(), booking.getCheckout()) &&
                Objects.equals(getBookingType(), booking.getBookingType()) &&
                Objects.equals(getBookingTime(), booking.getBookingTime()) &&
                Objects.equals(getBookingStatus(), booking.getBookingStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookingId(), getArrivalDate(), getCheckIn(), getCheckout(), getRoomNumber(), getCustomerId(), getBookingType(), getBookingTime(), getBookingStatus(), getTotalDay(), getCost(), getTotalCost(), getTotalRoom(), getTotalperson());
    }
}
