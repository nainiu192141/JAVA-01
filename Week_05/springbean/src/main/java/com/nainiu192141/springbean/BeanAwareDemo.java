package com.nainiu192141.springbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）
 * Created by xfx on 2021/2/20 23:06
 * @author 86134
 */
public class BeanAwareDemo {

    public static void main(String[] args) {
        // 使用xml装配
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
        Student student1 = (Student) context.getBean("student");
        System.out.println(student1.toString());
        //静态方法
        Student student2 = (Student) context.getBean("static-method");
        System.out.println(student2.toString());
        //构造函数
        Student student3 = (Student) context.getBean("constructor");
        System.out.println(student3.toString());
        //动态方法
        Student student4 = (Student) context.getBean("instance-method");
        System.out.println(student4.toString());
        //bean工厂
        Student student5 = (Student) context.getBean("factory-bean");
        System.out.println(student5.toString());
    }

}
