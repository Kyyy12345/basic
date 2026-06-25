package com.example.basic;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.entity.Animal;
import com.example.basic.entity.Product;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AnimalTests {
	@Autowired
	AnimalRepository ar;
	@Autowired
	ProductRepository pr;

	@Test
	void AnimalSelect() {
		// 1. '중형견 사료' 를 사준 사람의 이름은?
		log.info("이름: " + pr.findByName("중형견 사료").getAnimal().getOwner().getName());

		// 2. '얼룩이' 의 주인은?
		log.info("이름: " + ar.findByName("얼룩이").getOwner().getName());

		// 3) '몸통줄' 을 사용하는 동물은?
		log.info("이름 : " + pr.findByName("몸통줄").getAnimal().getName());

		// 4) 가격이 10,000원 이상인 모든 물품은?
		pr.findByPriceGreaterThanEqual(10000).forEach(product -> log.info("물품 이름: " + product.getName()));

		// 5) 나이가 5살 이상인 반려동물의 주인은?
		ar.findByAgeGreaterThanEqual(5)
				.forEach(animal -> log.info("동물 이름: " + animal.getName() + ", 주인: " + animal.getOwner().getName()));

	}

	@Test
	void aaa() {
		Optional<Animal> opt = ar.findById(1);
		Animal animal = opt.get();
		log.info(animal.toString());
		
	}

	@Test
	void aaa2() {
		List<Product> list = pr.findByNameContaining("형견 사료");
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getAnimal().getOwner().getName();
			log.info(name);
		}
	}

}
