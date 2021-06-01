package com.classproject.FitnessCenter.repository;

import com.classproject.FitnessCenter.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findAllById(Long id);

    /*
        Traži sve zaposlene po imenu ili prezimenu.

    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
    */
    /*
        Traži sve zaposlene po imenu, ignorišu se mala i velika slova.
     */
    List<Training> findByNameIgnoreCase(String name);

    /*
        Traži sve zaposlene po nazivu departmana.

    List<Employee> findByDepartmentName(String departmentName);
    */
    }

