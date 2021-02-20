package com.nainiu192141.springbean;


/**
 * @author 86134
 */
public interface StudentFactory {

    default Student create() {
        Student student = new Student();
        student.setId(4);
        student.setName("4444");
        return student;
    }

}
