package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    public enum UserRole {
        ADMIN, USER, TRAINER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role", nullable = false)
    private UserRole typeOfUser;

    @Column(name="username", nullable = false, length = 30, unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 25)
    private String lastName;

    @Column(name="phone", unique = true)
    private Integer contact;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="active")
    private Boolean active;

    public UserRole getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(UserRole typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", typeOfUser=" + typeOfUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", active=" + active +
                '}';
    }

}
