package com.classproject.FitnessCenter.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User implements Serializable {

    public Admin() {
        super();
    }
}
