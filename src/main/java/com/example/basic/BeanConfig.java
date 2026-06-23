package com.example.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.basic.component.Game;

@Configuration
public class BeanConfig {
    @Bean
    public String bean1() {
        return new String("Bean 1");
    }

    @Bean
    public Game game() {
        return new Game();
    }

    

}
