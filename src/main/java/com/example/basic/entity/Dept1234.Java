package com.example.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dept1234 {
    @Id
    int deptno;
    @Column(length=14)
    String dname;
    String loc;
}
