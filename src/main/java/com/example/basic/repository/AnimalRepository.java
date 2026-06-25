package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

    Animal findByName(String name);
    List<Animal> findByAgeGreaterThanEqual(Integer age);
}