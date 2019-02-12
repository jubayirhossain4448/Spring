package com.jubayir.exampleofeditingimage.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min= 2, max = 30, message = "Enter your name please!")
    private String name;

    @Min(value = 18, message = "Enter your valid age")
    private byte age;

    @NotNull(message = "Enter an email address")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Enter at least a course Please")
    private String[] courseCompleted;

    @NotEmpty(message = "Enter your message please!")
    private String gender;

    @NotEmpty(message = "Enter your round")
    private String round;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy:MM:dd")
    private Date birthDate;

    public Student(@NotNull @Size(min = 2, max = 30, message = "Enter your name please!") String name, @Min(value = 18, message = "Enter your valid age") byte age, @NotNull(message = "Enter an email address") @Email String email, @NotEmpty(message = "Enter at least a course Please") String[] courseCompleted, @NotEmpty(message = "Enter your message please!") String gender, @NotEmpty(message = "Enter your round") String round, Date regiDate, Date lastModifiedDate, Date birthDate) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCompleted = courseCompleted;
        this.gender = gender;
        this.round = round;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", courseCompleted=" + Arrays.toString(courseCompleted) +
                ", gender='" + gender + '\'' +
                ", round='" + round + '\'' +
                ", regiDate=" + regiDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                Objects.equals(getId(), student.getId()) &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getEmail(), student.getEmail()) &&
                Arrays.equals(getCourseCompleted(), student.getCourseCompleted()) &&
                Objects.equals(getGender(), student.getGender()) &&
                Objects.equals(getRound(), student.getRound()) &&
                Objects.equals(getRegiDate(), student.getRegiDate()) &&
                Objects.equals(getLastModifiedDate(), student.getLastModifiedDate()) &&
                Objects.equals(getBirthDate(), student.getBirthDate());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge(), getEmail(), getGender(), getRound(), getRegiDate(), getLastModifiedDate(), getBirthDate());
        result = 31 * result + Arrays.hashCode(getCourseCompleted());
        return result;
    }

    public Student() {

    }
}
