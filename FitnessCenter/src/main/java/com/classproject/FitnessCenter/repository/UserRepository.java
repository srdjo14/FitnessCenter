package com.classproject.FitnessCenter.repository;


import com.classproject.FitnessCenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getAllByActive(Boolean active);
}
