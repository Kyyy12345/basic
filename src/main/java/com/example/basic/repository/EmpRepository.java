package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {


    
} 
