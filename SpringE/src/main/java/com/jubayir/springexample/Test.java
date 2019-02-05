package com.jubayir.springexample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.time.Clock;

public class Test {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        Address address = (Address) factory.getBean("address");
        System.out.println(address);

        Student student = (Student) factory.getBean("st");
        System.out.println(student);
    }
}
