package com.nainiu192141;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nainiu192141.mapper")
public class AtomikosxademoApplication {

    public static void main(String[] args) {

        SpringApplication.run(AtomikosxademoApplication.class, args);
    }

}
