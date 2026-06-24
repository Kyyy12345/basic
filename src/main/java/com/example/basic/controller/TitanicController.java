package com.example.basic.controller;

import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TitanicController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/titanic-test")
    @ResponseBody
    public List<Map<String, Object>> titanic(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "1") int page) {
        int startNum = page * 10 - 10;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                // "select * from titanic where name like '%' + search + '%'"
                // "select * from titanic where name like '%?%'", search
                // "select * from titanic where name like concat('%', ?, '%')", search
                "SELECT * " +
                "FROM titanic " +
                "WHERE name LIKE CONCAT('%', ?, '%') " +
                "LIMIT ?, 10",
                search, startNum); // sql 문 작성
        return list;
    }
}