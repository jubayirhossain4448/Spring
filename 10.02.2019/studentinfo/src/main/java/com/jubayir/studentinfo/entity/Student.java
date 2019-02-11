package com.jubayir.studentinfo.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Enter your valid name")
    private String name;

    @Min(value = 18, message = "Enter your age")
    private byte age;

    @NotNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Select at least one course")
    private String [] courseCompleted;

    @NotEmpty(message = "Select Your Gender Please")
    private String gender;

    @NotEmpty(message = "Enter your Round")
    private String round;

    @Temporal(TemporalType.TIMESTAMP)
    private Date regidate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private long fileSize;
    private String fileName;

    private String filePath;
    private String fileExtension;

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30, message = "Enter your valid name") String name, @Min(value = 18, message = "Enter your age") byte age, @NotNull @Email String email, @NotEmpty(message = "Select at least one course") String[] courseCompleted, @NotEmpty(message = "Select Your Gender Please") String gender, @NotEmpty(message = "Enter your Round") String round, Date regidate, Date lastModifiedDate, Date birthDate) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCompleted = courseCompleted;
        this.gender = gender;
        this.round = round;
        this.regidate = regidate;
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

    public Date getRegidate() {
        return regidate;
    }

    public void setRegidate(Date regidate) {
        this.regidate = regidate;
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
                ", regidate=" + regidate +
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
                Objects.equals(getRegidate(), student.getRegidate()) &&
                Objects.equals(getLastModifiedDate(), student.getLastModifiedDate()) &&
                Objects.equals(getBirthDate(), student.getBirthDate());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge(), getEmail(), getGender(), getRound(), getRegidate(), getLastModifiedDate(), getBirthDate());
        result = 31 * result + Arrays.hashCode(getCourseCompleted());
        return result;
    }
}
