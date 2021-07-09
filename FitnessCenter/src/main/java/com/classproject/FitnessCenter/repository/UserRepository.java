package com.classproject.FitnessCenter.repository;


import com.classproject.FitnessCenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getAllByActive(Boolean active);
    Boolean existsUserByUsername(String username);
    User findUserByUsername(String username);
    Boolean existsUserByPosition(String position);
    User findUserByPosition (String position);

    User getOneById(Long userId);
}
