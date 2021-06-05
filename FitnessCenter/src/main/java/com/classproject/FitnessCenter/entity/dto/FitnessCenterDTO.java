package com.classproject.FitnessCenter.entity.dto;

public class FitnessCenterDTO {

    private Long id;
    private String naziv;
    private String address;
    private String email;
    private String contactPhone;


    public FitnessCenterDTO(Long id, String naziv, String address, String contactPhone, String email) {
        this.id = id;
        this.naziv = naziv;
        this.address = address;
        this.contactPhone = contactPhone;
        this.email = email;
    }

    public FitnessCenterDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
