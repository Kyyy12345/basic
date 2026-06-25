package com.example.basic.entity;

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
public class Playground {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(length = 50)
  String name;
 
  @Column(length = 50)
  String address;

  @Column(length = 20)
  String tel;

  @ManyToOne
  @JoinColumn(name = "playgroundAnimalId")
  PlaygroundAnimals playgroundAnimals;
}
