package com.classproject.FitnessCenter.entity;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;


@Entity
// ovom anotacijom se naglasava tip mapiranja "jedna tabela po hijerarhiji"
@Inheritance(strategy=SINGLE_TABLE)
// ovom anotacijom se navodi diskriminatorska kolona
@DiscriminatorColumn(name="type", discriminatorType=STRING)
public abstract class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role", nullable = false)
    private String typeOfUser;

    @Column(name="username", nullable = false, length = 30, unique = true)
    private String username;

    @Column(name="password", nullable = false, length = 30)
    private String password;

    @Column(name="first_name", nullable = false, length = 25)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 25)
    private String lastName;

    @Column(name="phone", unique = true)
    private String contact;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="active")
    private Boolean active;

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
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
