package com.classproject.FitnessCenter.Service;


import com.classproject.FitnessCenter.entity.Trainer;
import com.classproject.FitnessCenter.entity.User;
import com.classproject.FitnessCenter.entity.dto.LoginDTO;
import com.classproject.FitnessCenter.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    User loginUser(LoginDTO loginDTO) throws Exception;
    List<User> getActiveUser();
}
