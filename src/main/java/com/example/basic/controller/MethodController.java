package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MethodController {
    @GetMapping("req/get")
    public String get(@RequestParam String age) {
        return "GET " + age;
    }
}