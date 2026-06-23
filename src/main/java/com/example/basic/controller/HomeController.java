package com.example.basic.controller;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.basic.TestForm;
import com.example.basic.component.Game;
import com.example.basic.component.Music;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j // 로그와 관련된 도구
@Controller
public class HomeController {
    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired String s;
    @Autowired Game game;
    @Autowired Music m;


    @GetMapping("/")
    public String getHome1() {
        System.out.println("home!");
        System.out.println(s);
        System.out.println(game.play());
        System.out.println(m.play());
        log.debug("debug1");
        log.info("info!");
        return "home";
    }

    @GetMapping("/titanic") 
    @ResponseBody
    public List<Map<String, Object>> getTitanic() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from titanic");

        return list;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/testLabel")
    public String submitTest(@ModelAttribute TestForm testForm) {
        System.out.println("제출 답안: " + testForm.toString());
        return "testLabel";
    }
    
    

    
}
