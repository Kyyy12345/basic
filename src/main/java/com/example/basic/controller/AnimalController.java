package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.entity.Animal;
import com.example.basic.repository.AnimalRepository;

@Controller
public class AnimalController {
    @Autowired
    AnimalRepository ar;

    @GetMapping("/animal")
    @ResponseBody
    public List<Animal> animal() {
        return ar.findAll();
    }

    @GetMapping("/a")
    public String a(Model m) {
        m.addAttribute("age", 30);
        m.addAttribute("nickname", "John");
        return "a";
    }

    @GetMapping("userList")
    public String userList(Model model, @RequestParam int page) {
        model.addAttribute("page", page);
        List<Map<String, Object>> userList = new ArrayList<>();
        Map<String, Object> user = new HashMap<>();
        user.put("userId", "a");
        user.put("userName", "apple");
        user.put("userAge", 21);
        userList.add(user);
        user = new HashMap<>();
        user.put("userId", "b");
        user.put("userName", "banana");
        user.put("userAge", 22);
        userList.add(user);
        user = new HashMap<>();
        user.put("userId", "c");
        user.put("userName", "carrot");
        user.put("userAge", 23);
        userList.add(user);
        model.addAttribute("userList", userList);
        return "user_list";
    }

    @GetMapping("/animal_html")
    public String animalHtml(Model model) {
        List<Animal> animalList = ar.findAll();
        model.addAttribute("animalList", animalList);
        return "animal";

    }

}
