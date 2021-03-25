package com.libra.spring.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        // demo 自定义扫描注解
//        AnnotationConfigServletWebServerApplicationContext run = (AnnotationConfigServletWebServerApplicationContext)
//        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(run);
//
//        ClassLoader cl = DemoApplication.class.getClassLoader();
//        try {
//            classPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(
//                    ((Class<? extends Annotation>) ClassUtils.forName(ComponentMy.class.getName(), cl)), false));
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        classPathBeanDefinitionScanner.scan("com.libra.spring.demo");
//        Object bean = run.getBean("teacherService");
//        if (bean != null){
//            System.out.println("点个关注！");
//        }

    }

}
