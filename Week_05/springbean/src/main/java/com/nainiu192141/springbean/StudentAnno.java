package com.nainiu192141.springbean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @author 86134
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component(value = "student6")
public class StudentAnno implements Serializable {

    @Value("666")
    private int id;
    @Value("6666")
    private String name;

}
