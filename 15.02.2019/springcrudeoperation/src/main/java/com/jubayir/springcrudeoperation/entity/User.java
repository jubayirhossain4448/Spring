package com.jubayir.springcrudeoperation.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Please Enter your name here")
    private String name;

    @Min(value = 18, message = "Minimum age is 18")
    private byte age;

    @NotNull(message = "Please Enter your valid email")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Select at least one course Please")
    private String[] completedCourse;

    @NotEmpty(message = "Please Select your gender")
    private String gender;

    @NotEmpty(message = "Select your round please")
    private String round;

    public User() {
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getCompletedCourse() {
        return completedCourse;
    }

    public void setCompletedCourse(String[] completedCourse) {
        this.completedCourse = completedCourse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Arrays.equals(getCompletedCourse(), user.getCompletedCourse()) &&
                Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getRound(), user.getRound());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge(), getEmail(), getGender(), getRound());
        result = 31 * result + Arrays.hashCode(getCompletedCourse());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", completedCourse=" + Arrays.toString(completedCourse) +
                ", gender='" + gender + '\'' +
                ", round='" + round + '\'' +
                '}';
    }
}
