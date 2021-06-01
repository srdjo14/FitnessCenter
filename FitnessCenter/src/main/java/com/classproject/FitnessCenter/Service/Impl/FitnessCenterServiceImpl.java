package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.repository.FitnessCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnessCenterServiceImpl implements FitnessCenterService {

    private final FitnessCenterRepository fitnessCenterRepository;

    public FitnessCenterServiceImpl(FitnessCenterRepository fitnessCenterRepository) {
        this.fitnessCenterRepository = fitnessCenterRepository;
    }

    @Autowired

    @Override
    public FitnessCenter create(FitnessCenter fitnessCenter) throws Exception {
        if (fitnessCenter.getId() != null){
            throw new Exception("ID must be null");
        }
        FitnessCenter newFitnessCenter = this.fitnessCenterRepository.getOne(fitnessCenter);
        return newFitnessCenter;
    }
}
