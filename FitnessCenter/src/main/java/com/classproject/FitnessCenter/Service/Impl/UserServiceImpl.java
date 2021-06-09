package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.UserService;

import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     U ovoj metodi provjeravamo da li postoji korisnik sa tim korisnickim imenom
     kao i da li unesena sifra postoji u bazi.
    */
    @Override
    public User loginUser(User user) throws Exception {
        if(userRepository.existsUserByUsername(user.getUsername())){
            User user1 = userRepository.findUserByUsername(user.getUsername());
            if(user1.getActive() && user1.getPassword().equals(user.getPassword())){
                return user1;
            }
        } return null;
    }

    @Override
    public List<User> getActiveUser() {
        return userRepository.getAllByActive(true);
    }
}
