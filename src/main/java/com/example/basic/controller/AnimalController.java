package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.entity.Animal;
import com.example.basic.repository.AnimalRepository;


@Controller
public class AnimalController {
    @Autowired AnimalRepository ar;

    @GetMapping("/animal")
    @ResponseBody
    public List<Animal> animal() {
        return ar.findAll();
    }
    
}
