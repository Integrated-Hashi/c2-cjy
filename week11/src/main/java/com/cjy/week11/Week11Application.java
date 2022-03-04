package com.cjy.week11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjy.week11.mapper")
public class Week11Application {

    public static void main(String[] args) {
        SpringApplication.run(Week11Application.class, args);
    }

}
