package com.example.basic.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(length = 50)
  String name;

  @Column(nullable = true)
  Integer age;

  @ManyToOne
  @JoinColumn(name="owner_id")
  Owner owner;
  
  @ManyToOne
  @JoinColumn(name = "playgroundAnimal_id")
  PlaygroundAnimals playgroundAnimals;

  
}
