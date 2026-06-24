package com.example.basic.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

    List<Emp> findByHiredate(Date hiredate);
    Emp findByEname(String ename);
    // List<Emp> findBySalGreaterThanEqualAndOrderBySalDesc(Integer sal);
} 
