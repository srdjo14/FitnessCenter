package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fit-center")
public class FitnessCenter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private Integer contactPhone;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "fitnessCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trainer> trainers = new HashSet<>();

    @OneToMany(mappedBy = "fitnesCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Hall> halls = new HashSet<>();
}
