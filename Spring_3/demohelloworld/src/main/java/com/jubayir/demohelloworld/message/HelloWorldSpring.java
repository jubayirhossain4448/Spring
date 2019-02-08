package com.jubayir.demohelloworld.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {

    public static void main(String[] args) {

        // Initialize Spring ApplicationContext
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
