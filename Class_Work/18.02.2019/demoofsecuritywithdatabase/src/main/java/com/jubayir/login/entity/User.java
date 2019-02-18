package com.jubayir.login.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
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

    @NotNull(message = "Please Enter a valid password")
    @Size(min = 3, max = 25)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id"))
    private Set<Role> roles;

    public User(String jubayir, String s, String s1, String java, String male, String s2, String s3) {

    }

    public Set<Role> getRoles() {
        return roles;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String name, @Min(value = 18, message = "Hey, Minium Age is 18") byte age, @NotNull(message = "Enter An Email Address") @Email String email, @NotEmpty(message = "Enter A Course At least") String[] courseCompleted, @NotEmpty(message = "Enter Gender") String gender, @NotEmpty(message = "Enter Round") String round, @NotNull(message = "Please Enter a valid password") @Size(min = 3, max = 25) String password, Set<Role> roles) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCompleted = courseCompleted;
        this.gender = gender;
        this.round = round;
        this.password = password;
        this.roles = roles;
    }

    public User(User user) {
        this.name = user.name;
        this.age = user.age;
        this.email = user.email;
        this.courseCompleted = user.courseCompleted;
        this.gender = user.gender;
        this.round = user.round;
        this.password = user.password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getName(), getAge(), getEmail(), getGender(), getRound(), getPassword());
        result = 31 * result + Arrays.hashCode(getCourseCompleted());
        return result;
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
                ", password='" + password + '\'' +
                '}';
    }
}
