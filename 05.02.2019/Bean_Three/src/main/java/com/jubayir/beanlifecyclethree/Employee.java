package com.jubayir.beanlifecyclethree;

public class Employee {
private int id;

private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public  void init(){
        System.out.println("Hi! I am from init method");
    }

    public void cleanUp(){
        System.out.println("Hello! I am from clean Up Method");
    }
}
