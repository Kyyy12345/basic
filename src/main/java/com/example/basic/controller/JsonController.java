package com.example.basic.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.ExamResponse;
import com.example.basic.User;

@RestController
public class JsonController {
    @GetMapping("/json/exam")
    public ExamResponse exam() {
        User u1 = new User("가", "A", "1");
        User u2 = new User("나", "B", "2");

        ExamResponse response = new ExamResponse();
        response.setCount(2);
        response.setList(Arrays.asList(u1, u2));

        return response;
    }
}
