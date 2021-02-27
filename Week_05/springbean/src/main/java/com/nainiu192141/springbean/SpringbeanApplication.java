package com.nainiu192141.springbean;

import io.kimmking.aop.ISchool;
import io.kimmking.spring02.Klass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbeanApplication.class, args);
        ISchool iSchool = applicationContext.getBean(ISchool.class);
        System.out.println(iSchool);
        iSchool.ding();
        Klass klass = applicationContext.getBean(Klass.class);
        klass.dong();

    }
}
