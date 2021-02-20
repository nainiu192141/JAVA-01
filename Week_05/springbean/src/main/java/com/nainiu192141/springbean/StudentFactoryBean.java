package com.nainiu192141.springbean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by xfx on 2021/2/20 23:42
 */
public class StudentFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Student student = new Student();
        student.setId(555);
        student.setName("5555");
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }
}
