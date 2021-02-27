package com.nainiu192141.springbean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @author 86134
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Student implements Serializable {

    private int id;
    private String name;

    public void init(){
        System.out.println("hello...........");
    }

    public static Student create(){
        return new Student(1011,"KK1101");
    }
}
