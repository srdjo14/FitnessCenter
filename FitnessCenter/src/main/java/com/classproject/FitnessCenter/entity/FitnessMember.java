package com.classproject.FitnessCenter.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FitnessMember extends User implements Serializable {

    private List<Training> doneTraining = new ArrayList<Training>();

    private List<Training> regTraining = new ArrayList<Training>();

    private List<Training> rateTraining = new ArrayList<Training>();


}
