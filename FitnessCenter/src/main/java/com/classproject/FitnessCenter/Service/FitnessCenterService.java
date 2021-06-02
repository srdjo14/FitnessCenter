package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.FitnessCenter;

public interface FitnessCenterService {
    FitnessCenter create(FitnessCenter fitnessCenter) throws Exception;
    FitnessCenter update(FitnessCenter fitnessCenter) throws Exception;
    void delete(Long id);
}
