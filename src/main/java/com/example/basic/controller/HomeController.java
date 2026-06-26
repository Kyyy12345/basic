package com.example.basic.controller;

import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.basic.component.Game;
import com.example.basic.component.Music;
import com.example.basic.entity.Dept;
import com.example.basic.entity.Emp;
import com.example.basic.model.TestForm;
import com.example.basic.repository.DeptRepository;
import com.example.basic.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Slf4j // 로그와 관련된 도구
@Controller
public class HomeController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    String s;
    @Autowired
    Game game;
    @Autowired
    Music m;
    @Autowired
    DeptRepository dr;
    @Autowired
    EmpRepository er;

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
        Dept d = new Dept();
        d.setDeptno(1);
        d.setDname("A");
        d.setLoc("부산");
        dr.save(d);
        List<Dept> list = dr.findAll(); // select SQL 생성 및 실행
        System.out.println(list);
        return "test";
    }

    @PostMapping("/testLabel")
    public String submitTest(@ModelAttribute TestForm testForm) {
        System.out.println("제출 답안: " + testForm.toString());
        return "testLabel";
    }

    @GetMapping("/emp-all")
    @ResponseBody
    public List<Emp> empAll() {
        List<Emp> empList = er.findAll();
        return empList;
    }

    @GetMapping("/visitor")
    @ResponseBody
    public String visitor(
            @RequestHeader("user-agent") String userAgent, HttpSession session) {
        session.setAttribute("user", 123);
        return userAgent;
    }

    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "여기는 메인 페이지";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public String upload1Post(MultipartHttpServletRequest mRequest) {
        String result = "";
        MultipartFile mFile = mRequest.getFile("file");
        String oName = mFile.getOriginalFilename() + "_" + System.currentTimeMillis();
        result += oName + "<br>" + mFile.getSize();
        try {
            mFile.transferTo(new File("c:/upload/" + oName));
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public String upload2(@RequestParam("file") List<MultipartFile> mFile) {
        String result = "";
        for (int i = 0; i < mFile.size(); i++) {
            MultipartFile file = mFile.get(i);
            String oName = file.getOriginalFilename();
            result += oName + "<br>" + file.getSize();
        }

        return result;
    }

}
