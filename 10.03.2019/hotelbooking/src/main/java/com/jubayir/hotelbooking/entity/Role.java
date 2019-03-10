package com.jubayir.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Enter Role Name")
    @Size(min = 2,max = 20,message = "Rolename must be between 2 and 20 Characters")
    private String roleName;

    public Role() {
    }

    public Role(@NotEmpty(message = "Enter Role Name") @Size(min = 2, max = 20, message = "Rolename must be between 2 and 20 Characters") String roleName) {
        this.roleName = roleName;
    }

    public Role(Long id){
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId()) &&
                Objects.equals(getRoleName(), role.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoleName());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
