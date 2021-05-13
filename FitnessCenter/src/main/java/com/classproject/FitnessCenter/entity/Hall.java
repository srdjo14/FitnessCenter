package com.classproject.FitnessCenter.entity;

import javax.persistence.*;

@Entity
@Table(name = "hall")
public class Hall {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer capacity;

    @Column
    private Integer numberOfHall;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCenter fitnessCenter;

}
