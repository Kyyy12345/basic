package com.example.basic.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "table_exam_1")
public class TableExam1 {
    @Id
    Integer id;
    Date createdDate;
    
    String title;
    String content;
    Long price;
    String brand;
    
}