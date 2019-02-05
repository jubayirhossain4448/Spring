package com.jubayir.demoofall;

public class Employee {
    private int name;

    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                '}';
    }
}
