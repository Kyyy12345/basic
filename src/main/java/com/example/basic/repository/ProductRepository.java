package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{

    Product findByName(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceGreaterThanEqual(Integer price);

}
