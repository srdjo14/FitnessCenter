package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.FitnessCenterService;
import com.classproject.FitnessCenter.entity.FitnessCenter;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.repository.FitnessCenterRepository;
import com.classproject.FitnessCenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public FitnessCenter create(FitnessCenter fitnessCenter) throws Exception {
        if (fitnessCenter.getId() != null){
            throw new Exception("ID must be null");
        }
        User user = userRepository.findUserByPosition();

        FitnessCenter newFitnessCenter = this.fitnessCenterRepository.save(fitnessCenter);
        return newFitnessCenter;
    }

    @Override
    public FitnessCenter update(FitnessCenter fitnessCenter) throws Exception {
        FitnessCenter fitnessCenterToUpdate = this.fitnessCenterRepository.getOne(fitnessCenter.getId());
        if (fitnessCenterToUpdate == null) {
            throw new Exception("Fitness centar ne postoji!");
        }

        fitnessCenterToUpdate.setNaziv(fitnessCenter.getNaziv());
        fitnessCenterToUpdate.setAddress(fitnessCenter.getAddress());
        fitnessCenterToUpdate.setEmail(fitnessCenter.getEmail());
        fitnessCenterToUpdate.setContactPhone(fitnessCenter.getContactPhone());

        // Cuvanje u bazi
        FitnessCenter savedFc = this.fitnessCenterRepository.save(fitnessCenterToUpdate);
        return savedFc;
    }

    @Override
    public void delete(Long id) {
        this.fitnessCenterRepository.deleteById(id);
    }
}
