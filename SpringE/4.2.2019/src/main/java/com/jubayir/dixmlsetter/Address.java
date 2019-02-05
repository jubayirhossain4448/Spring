package com.jubayir.dixmlsetter;

public class Address {
    private String city;
    private String state;
    private String county;

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", county='" + county + '\'' +
                '}';
    }
}
