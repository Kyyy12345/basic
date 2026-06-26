package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.basic.entity.HolidayParking;
import com.example.basic.repository.HolidayParkingRepository;

@Controller
public class HolidayParkingController {

    @Autowired HolidayParkingRepository hpr;

    @GetMapping("/holidayParking")
    public String hp(@RequestParam(defaultValue = "1") int page, Model model) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<HolidayParking> pageResult = hpr.findAll(pageable);

        int totalPages = pageResult.getTotalPages();
        int pageGroup = (page - 1) / 10;       // 0부터 시작하는 그룹 번호
        int startPage = pageGroup * 10 + 1;     // 그룹 첫 페이지 (1, 11, 21 ...)
        int endPage = Math.min(startPage + 9, totalPages); // 그룹 마지막 페이지

        model.addAttribute("holidayParkingList", pageResult.getContent());
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "holidayParking";
    }

    @GetMapping("/holidayParking2")
    public String hp(Model model ) {
        Pageable pageable = PageRequest.of(0, 10);
        Page<HolidayParking> p = hpr.findByOrderByInstitutionAsc(pageable);
        List<HolidayParking> list = p.getContent();
        model.addAttribute("list", list);

        return "holiday_parking";
    }
}
