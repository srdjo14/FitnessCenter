package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.AuthenticationService;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean isLoggedIn(User user) throws Exception {
        return user.getActive();
    }
}
