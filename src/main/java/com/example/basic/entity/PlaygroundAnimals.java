package com.example.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PlaygroundAnimals {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

}
