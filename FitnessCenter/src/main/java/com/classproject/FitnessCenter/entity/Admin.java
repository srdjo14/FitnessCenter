package com.classproject.FitnessCenter.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User implements Serializable {
}
