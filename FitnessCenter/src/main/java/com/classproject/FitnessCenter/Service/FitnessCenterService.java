package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.Training;

import java.util.List;

public interface FitnessCenterService {
    List<FitnessCenter> findAll();
    FitnessCenter create(FitnessCenter fitnessCenter) throws Exception;
    FitnessCenter update(FitnessCenter fitnessCenter) throws Exception;
    void delete(Long id);
}
