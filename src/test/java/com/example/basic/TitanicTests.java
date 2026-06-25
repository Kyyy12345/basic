package com.example.basic;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.basic.entity.Animal;
import com.example.basic.entity.Product;
import com.example.basic.entity.Titanic;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.ProductRepository;
import com.example.basic.repository.TitanicRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TitanicTests {
	@Autowired TitanicRepository tr;

	@Test
	void aaa() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Titanic> pt = tr.findAll(pageable);
		log.info(pt.getContent().toString());
	}
	
}
