package com.jubayir.exampleofcrudeoperation.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Enter your name")
    private String name;

    @Min(value = 18, message = "Minimum age is 18")
    private byte age;

    @NotNull(message = "Enter a valid email")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Enter at least one course name")
    private String[] courseCompleted;

    @NotEmpty(message = "Select your gender Please")
    private String gender;

    @NotEmpty(message = "Select a round")
    private String round;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    public User() {
    }

    public User(@NotNull @Size(min = 2, max = 30, message = "Enter your name") String name, @Min(value = 18, message = "Minimum age is 18") byte age, @NotNull(message = "Enter a valid email") @Email String email, @NotEmpty(message = "Enter at least one course name") String[] courseCompleted, @NotEmpty(message = "Select your gender Please") String gender, @NotEmpty(message = "Select a round") String round, Date regiDate, Date lastModifiedDate) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCompleted = courseCompleted;
        this.gender = gender;
        this.round = round;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
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

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
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

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", courseCompleted=" + Arrays.toString(courseCompleted) +
                ", gender='" + gender + '\'' +
                ", round='" + round + '\'' +
                ", regiDate=" + regiDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
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
                Arrays.equals(getCourseCompleted(), user.getCourseCompleted()) &&
                Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getRound(), user.getRound()) &&
                Objects.equals(getRegiDate(), user.getRegiDate()) &&
                Objects.equals(getLastModifiedDate(), user.getLastModifiedDate());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge(), getEmail(), getGender(), getRound(), getRegiDate(), getLastModifiedDate());
        result = 31 * result + Arrays.hashCode(getCourseCompleted());
        return result;
    }
}
