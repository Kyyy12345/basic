package com.example.basic.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.ExamResponse;
import com.example.basic.model.User;

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

    @GetMapping("/req/data")
    public Map<String, String> data(@RequestParam(required = false) String area,
            @RequestParam(required = false) String score) {
        Map map = new HashMap<>();
        if (area != null) {
            map.put("area", area);
        }
        if (score != null) {
            map.put("score", score);
        }
        return map;
    }
}
