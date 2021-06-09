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

    @Override
    public User create(User user) throws Exception {
        if(user.getId() != null){
            throw new Exception("ID must be null");
        }

        user.getUsername()

        User newUser = this.userRepository.save(user);
        return newUser;
    }

    @Override
    public List<User> getActiveUser() {
        return userRepository.getAllByActive(true);
    }
}
