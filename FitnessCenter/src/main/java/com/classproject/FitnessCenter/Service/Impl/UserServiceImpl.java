package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.UserService;

import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.entity.dto.LoginDTO;
import com.classproject.FitnessCenter.entity.dto.UserDTO;
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
    public User loginUser(LoginDTO loginDTO) throws Exception {
        User user = userRepository.findUserByUsername(loginDTO.getUsername());
        if(user==null || !user.getPassword().equals(loginDTO.getPassword()) || user.getActive()==false){
            return null;
        }
        return user;
    }

    @Override
    public List<User> getActiveUser() {
        return userRepository.getAllByActive(true);
    }

    @Override
    public User findOne(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public User findOneById(Long userId) {
        return this.userRepository.getOneById(userId);
    }
}
