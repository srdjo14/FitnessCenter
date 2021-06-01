package com.classproject.FitnessCenter.Service.Impl;

import com.classproject.FitnessCenter.Service.UserService;
import com.classproject.FitnessCenter.entity.Member;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.repository.MemberRepository;
import com.classproject.FitnessCenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository; }

    @Override
    public User findOne(Long id){
        User user = this.userRepository.getOne(id);
        return user;
    }
}
