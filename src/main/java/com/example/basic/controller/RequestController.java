package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RequestController {
    @GetMapping("req/http")
    public String http(HttpServletRequest request, @RequestParam String name, @RequestParam int pageNum) {
        // String name = request.getParameter("name");
        // String pageNum = request.getParameter("pageNum");
        return name + ", " + pageNum;
    }
}
