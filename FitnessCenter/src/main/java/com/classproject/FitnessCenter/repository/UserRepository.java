package com.classproject.FitnessCenter.repository;


import com.classproject.FitnessCenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
