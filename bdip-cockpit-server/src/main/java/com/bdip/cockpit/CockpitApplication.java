package com.bdip.cockpit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bdip.cockpit.dao")
public class CockpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(CockpitApplication.class, args);
    }

}
