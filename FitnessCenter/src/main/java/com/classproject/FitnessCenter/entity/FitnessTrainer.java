package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitnessTrainer extends User implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne(fetch = FetchType.EAGER)
        private User user;

        @Column
        private Integer mediumRateValue;

        private List<Training> trainings = new ArrayList<Training>();

}
