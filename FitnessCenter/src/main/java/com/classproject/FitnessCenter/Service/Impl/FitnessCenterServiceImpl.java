package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.repository.FitnessCenterRepository;
import com.classproject.FitnessCenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessCenterServiceImpl implements FitnessCenterService {

    private final FitnessCenterRepository fitnessCenterRepository;
    private final UserRepository userRepository;
    @Autowired
    public FitnessCenterServiceImpl(FitnessCenterRepository fitnessCenterRepository, UserRepository userRepository) {
        this.fitnessCenterRepository = fitnessCenterRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<FitnessCenter> findAll() {
        List<FitnessCenter> fitnessCenters = this.fitnessCenterRepository.findAll();
        return fitnessCenters;
    }

    @Override
    public FitnessCenter create(FitnessCenter fitnessCenter) throws Exception {
        if (fitnessCenter.getId() != null){
            throw new Exception("ID must be null");
        }

        FitnessCenter newFitnessCenter = this.fitnessCenterRepository.save(fitnessCenter);
        return newFitnessCenter;
    }

    @Override
    public FitnessCenter update(FitnessCenter fitnessCenter) throws Exception {
        return fitnessCenterRepository.save(fitnessCenter);
    }

    @Override
    public void delete(Long id) {
        this.fitnessCenterRepository.deleteById(id);
    }

    @Override
    public Optional<FitnessCenter> findOne(Long id) {
        return fitnessCenterRepository.findById(id);
    }

    @Override
    public FitnessCenter findOneById(Long id) {
        return fitnessCenterRepository.findOneById(id);
    }

}
