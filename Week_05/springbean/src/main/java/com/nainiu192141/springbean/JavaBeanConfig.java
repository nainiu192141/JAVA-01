package com.nainiu192141.springbean;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 86134
 */
@Data
@Configuration
public class JavaBeanConfig {

    @Bean(name = "studentBean")
    public StudentBean getStudentBean(){
        StudentBean student = new StudentBean();
        student.setId(777);
        student.setName("7777");
        return student;
    }
}
