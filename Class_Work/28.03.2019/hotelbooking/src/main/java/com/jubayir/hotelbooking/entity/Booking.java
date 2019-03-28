package com.jubayir.hotelbooking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long bookingId;

    private String paymentType;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date fromDate;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date toDate;


    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date arrivalDate;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date checkIn;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date checkout;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date bookingTime;

    private String bookingStatus;


    private int noOfDays;

    private double unitPerDay;

    private double totalPrice;

    private double advancedPrice;

    private double duePrice;

    private int noOfPerson;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "booking_customer",
            joinColumns = @JoinColumn (name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<User> customers;

    public Booking() {
    }

    public Booking(long bookingId, String paymentType, Date fromDate, Date toDate, Date arrivalDate, Date checkIn, Date checkout, Date bookingTime, String bookingStatus, int noOfDays, double unitPerDay, double totalPrice, double advancedPrice, double duePrice, int noOfPerson, Set<User> customers) {
        this.bookingId = bookingId;
        this.paymentType = paymentType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.arrivalDate = arrivalDate;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.bookingTime = bookingTime;
        this.bookingStatus = bookingStatus;
        this.noOfDays = noOfDays;
        this.unitPerDay = unitPerDay;
        this.totalPrice = totalPrice;
        this.advancedPrice = advancedPrice;
        this.duePrice = duePrice;
        this.noOfPerson = noOfPerson;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public double getUnitPerDay() {
        return unitPerDay;
    }

    public void setUnitPerDay(double unitPerDay) {
        this.unitPerDay = unitPerDay;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getAdvancedPrice() {
        return advancedPrice;
    }

    public void setAdvancedPrice(double advancedPrice) {
        this.advancedPrice = advancedPrice;
    }

    public double getDuePrice() {
        return duePrice;
    }

    public void setDuePrice(double duePrice) {
        this.duePrice = duePrice;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Set<User> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<User> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return getBookingId() == booking.getBookingId() &&
                getNoOfDays() == booking.getNoOfDays() &&
                Double.compare(booking.getUnitPerDay(), getUnitPerDay()) == 0 &&
                Double.compare(booking.getTotalPrice(), getTotalPrice()) == 0 &&
                Double.compare(booking.getAdvancedPrice(), getAdvancedPrice()) == 0 &&
                Double.compare(booking.getDuePrice(), getDuePrice()) == 0 &&
                getNoOfPerson() == booking.getNoOfPerson() &&
                Objects.equals(getId(), booking.getId()) &&
                Objects.equals(getPaymentType(), booking.getPaymentType()) &&
                Objects.equals(getFromDate(), booking.getFromDate()) &&
                Objects.equals(getToDate(), booking.getToDate()) &&
                Objects.equals(getArrivalDate(), booking.getArrivalDate()) &&
                Objects.equals(getCheckIn(), booking.getCheckIn()) &&
                Objects.equals(getCheckout(), booking.getCheckout()) &&
                Objects.equals(getBookingTime(), booking.getBookingTime()) &&
                Objects.equals(getBookingStatus(), booking.getBookingStatus()) &&
                Objects.equals(getCustomers(), booking.getCustomers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookingId(), getPaymentType(), getFromDate(), getToDate(), getArrivalDate(), getCheckIn(), getCheckout(), getBookingTime(), getBookingStatus(), getNoOfDays(), getUnitPerDay(), getTotalPrice(), getAdvancedPrice(), getDuePrice(), getNoOfPerson(), getCustomers());
    }
}
