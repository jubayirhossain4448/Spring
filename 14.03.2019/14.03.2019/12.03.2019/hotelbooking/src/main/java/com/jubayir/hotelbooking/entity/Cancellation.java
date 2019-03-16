package com.jubayir.hotelbooking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cancellation")
public class Cancellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingId;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrivalTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkout;

    private int roomNumber;

    private int customerId;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cancelTime;

    private boolean status;

    public Cancellation() {
    }

    public Cancellation(String bookingId, Date arrivalTime, Date checkout, int roomNumber, int customerId, Date cancelTime, boolean status) {
        this.bookingId = bookingId;
        this.arrivalTime = arrivalTime;
        this.checkout = checkout;
        this.roomNumber = roomNumber;
        this.customerId = customerId;
        this.cancelTime = cancelTime;
        this.status = status;
    }

    public Cancellation(Cancellation cancellation) {
        this.bookingId = cancellation.bookingId;
        this.arrivalTime = cancellation.arrivalTime;
        this.checkout = cancellation.checkout;
        this.roomNumber = cancellation.roomNumber;
        this.customerId = cancellation.customerId;
        this.cancelTime = cancellation.cancelTime;
        this.status = cancellation.status;
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

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cancellation)) return false;
        Cancellation that = (Cancellation) o;
        return getRoomNumber() == that.getRoomNumber() &&
                getCustomerId() == that.getCustomerId() &&
                isStatus() == that.isStatus() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getBookingId(), that.getBookingId()) &&
                Objects.equals(getArrivalTime(), that.getArrivalTime()) &&
                Objects.equals(getCheckout(), that.getCheckout()) &&
                Objects.equals(getCancelTime(), that.getCancelTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookingId(), getArrivalTime(), getCheckout(), getRoomNumber(), getCustomerId(), getCancelTime(), isStatus());
    }
}
