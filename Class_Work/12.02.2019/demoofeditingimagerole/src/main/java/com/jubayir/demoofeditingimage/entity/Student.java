package com.jubayir.demoofeditingimage.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stu")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String name;

    @Min(value = 18, message = "Hey, Minium Age is 18")
    private byte age;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Enter A Course At least")
    private String[] courseCompleted;

    @NotEmpty(message = "Enter Gender")
    private String gender;

    @NotEmpty(message = "Enter Round")
    private String round;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    //////File Upload==============
    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;

    @ManyToMany(fetch = FetchType.EAGER) //To make a relationship between two tables
    @JoinTable(name = "student_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String name, @Min(value = 18, message = "Hey, Minium Age is 18") byte age, @NotNull(message = "Enter An Email Address") @Email String email, @NotEmpty(message = "Enter A Course At least") String[] courseCompleted, @NotEmpty(message = "Enter Gender") String gender, @NotEmpty(message = "Enter Round") String round, Date regiDate, Date lastModifiedDate, Date birthDate, long fileSize, String fileName, String filePath, String fileExtension) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCompleted = courseCompleted;
        this.gender = gender;
        this.round = round;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
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
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() &&
                getFileSize() == student.getFileSize() &&
                Objects.equals(getId(), student.getId()) &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getEmail(), student.getEmail()) &&
                Arrays.equals(getCourseCompleted(), student.getCourseCompleted()) &&
                Objects.equals(getGender(), student.getGender()) &&
                Objects.equals(getRound(), student.getRound()) &&
                Objects.equals(getRegiDate(), student.getRegiDate()) &&
                Objects.equals(getLastModifiedDate(), student.getLastModifiedDate()) &&
                Objects.equals(getBirthDate(), student.getBirthDate()) &&
                Objects.equals(getFileName(), student.getFileName()) &&
                Objects.equals(getFilePath(), student.getFilePath()) &&
                Objects.equals(getFileExtension(), student.getFileExtension());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge(), getEmail(), getGender(), getRound(), getRegiDate(), getLastModifiedDate(), getBirthDate(), getFileSize(), getFileName(), getFilePath(), getFileExtension());
        result = 31 * result + Arrays.hashCode(getCourseCompleted());
        return result;
    }
}
