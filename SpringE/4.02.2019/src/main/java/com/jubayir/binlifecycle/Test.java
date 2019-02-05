package com.jubayir.binlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");
        SimpleBean simpleBean = (SimpleBean) context.getBean("sb1");
        System.out.println(simpleBean);

        SimpleBean simpleBean2 = (SimpleBean) context.getBean("sb2");
        System.out.println(simpleBean2);
    }
}
