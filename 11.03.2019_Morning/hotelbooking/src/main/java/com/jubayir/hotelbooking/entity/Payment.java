package com.jubayir.hotelbooking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingId;

    private String customerId;

    private String paymentType;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    public Payment() {
    }

    public Payment(String bookingId, String customerId, String paymentType, Date paymentTime) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.paymentTime = paymentTime;
    }

    public Payment(Payment payment) {
        this.bookingId = payment.bookingId;
        this.customerId = payment.customerId;
        this.paymentType = payment.paymentType;
        this.paymentTime = payment.paymentTime;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId()) &&
                Objects.equals(getBookingId(), payment.getBookingId()) &&
                Objects.equals(getCustomerId(), payment.getCustomerId()) &&
                Objects.equals(getPaymentType(), payment.getPaymentType()) &&
                Objects.equals(getPaymentTime(), payment.getPaymentTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookingId(), getCustomerId(), getPaymentType(), getPaymentTime());
    }
}
