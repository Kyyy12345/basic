package com.example.basic;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.ServiceCenter;
import com.example.basic.repository.ServiceCenterRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BasicApplicationTests {
	@Autowired ServiceCenterRepository scr;

	@Test
	void 수정() {
		// pk 값 여부
		ServiceCenter sc = new ServiceCenter();
		sc.setId(1); // <== 이것 덕분에 수정으로 동작
		sc.setCustomer("김길동");
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

}
