package com.example.basic.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp")
public class Emp {
    @Id // 기본 키(Primary Key) 설정
    @Column(name = "empno")
    private Integer empno;

    @Column(name = "ename", length = 50)
    private String ename;

    @Column(name = "job", length = 50)
    private String job;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "hiredate")
    private LocalDateTime hiredate;

    @Column(name = "sal")
    private Double sal;

    @Column(name = "comm")
    private Double comm;

    @Column(name = "deptno")
    private Integer deptno;
}
