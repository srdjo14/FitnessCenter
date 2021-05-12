package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FitnessMember extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Training> doneTraining = new ArrayList<Training>();

    private List<Training> regTraining = new ArrayList<Training>();

    private List<Training> rateTraining = new ArrayList<Training>();

    @Override
    public String toString() {
        return "FitnessMember{" +
                "id=" + id +
                ", user=" + user+
                ", doneTraining=" + doneTraining +
                ", regTraining=" + regTraining +
                ", rateTraining=" + rateTraining +
                '}';
    }
}
