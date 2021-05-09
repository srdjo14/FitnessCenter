package com.classproject.FitnessCenter.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitnessCent implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address;

    @Column
    private Integer contactPhone;

    @Column
    private String email;

    @Column
    private List<FitnessTrainer> trainers = new ArrayList<FitnessTrainer>();

}
