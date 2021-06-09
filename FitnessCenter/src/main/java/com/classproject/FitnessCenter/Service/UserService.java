package com.classproject.FitnessCenter.Service;


import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.User;

import java.util.List;

public interface UserService {

    User create(User user) throws Exception;
    List<User> getActiveUser();
}
