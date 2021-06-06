package com.classproject.FitnessCenter.Service;

import com.classproject.FitnessCenter.entity.User;

public interface AuthenticationService {

    Boolean isLoggedIn(User user) throws Exception;
}
