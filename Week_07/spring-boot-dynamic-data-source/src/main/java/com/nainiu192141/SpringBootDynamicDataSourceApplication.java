package com.nainiu192141;

import com.nainiu192141.datasource.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@MapperScan("com.nainiu192141.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class SpringBootDynamicDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDynamicDataSourceApplication.class, args);
    }

}
