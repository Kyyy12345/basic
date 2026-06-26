package com.example.basic.repository;

import com.example.basic.entity.HolidayParking;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayParkingRepository extends JpaRepository<HolidayParking, Integer> {
    // 기관명 오름차순으로 정렬
    // 한 페이지에 20건씩
    Page<HolidayParking> findByOrderByInstitutionAsc(Pageable pageable);
}


