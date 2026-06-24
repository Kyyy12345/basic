package com.example.basic;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.Emp;
import com.example.basic.entity.ServiceCenter;
import com.example.basic.entity.Titanic;
import com.example.basic.repository.EmpRepository;
import com.example.basic.repository.ServiceCenterRepository;
import com.example.basic.repository.TitanicRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BasicApplicationTests {
	@Autowired ServiceCenterRepository scr;
	@Autowired EmpRepository er;
	@Autowired TitanicRepository tr;

	@Test
	void 수정() {
		// pk 값 여부
		ServiceCenter sc = new ServiceCenter();
		sc.setId(1); // <== 이것 덕분에 수정으로 동작
		sc.setCustomer("김길동");
		scr.save(sc);
	}

	@Test
	void 삭제() {
		scr.deleteById(1);
	}

	@Test
	void 조회후수정() {
		
		
		Optional<ServiceCenter> opt = scr.findById(2);
		ServiceCenter sc = opt.get();
		sc.setCustomer("박길동");
		scr.save(sc);
		
	}

	@Test
	void 조회() {
		List<ServiceCenter> list = scr.findAll();
		System.out.println(list);
		log.info(list.toString());
	}
	
	@Test
	void 입력() {
		ServiceCenter sc = new ServiceCenter();
		sc.setCustomer("홍길동");
		sc.setPrdName("무선청소기");
		sc.setPurDate(LocalDateTime.now());
		sc.setVstDate(new Date());
		scr.save(sc);
	}

	@Test
	void 입사일자로조회() {
		Emp emp = er.findByEname("SCOTT");
		log.info(emp.toString());
	}

	// 급여가 3000이상인 사람들을 급여가 높은순으로 조회하기
	// @Test
	// void 급여로조회() {
	// 	List<Emp> list = er.findBySalGreaterThanEqualAndOrderBySalDesc(3000);
	// 	log.info(list.toString());
	// }
		
	@Test
	void 생존자로조회() {
		List<Titanic> titanicList = tr.findBySurvivedOrderByAgeDesc(1);
		log.info(titanicList.toString());
	}

}
