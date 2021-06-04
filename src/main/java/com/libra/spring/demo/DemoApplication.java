package com.libra.spring.demo;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.libra.spring.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        // demo 自定义扫描注解
        //        AnnotationConfigServletWebServerApplicationContext run = (AnnotationConfigServletWebServerApplicationContext)SpringApplication.run(DemoApplication.class, args);
        //
        //        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(run);
        //
        //        ClassLoader cl = DemoApplication.class.getClassLoader();
        //        try {
        //            classPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(
        //                    ((Class<? extends Annotation>) ClassUtils.forName(ComponentMy.class.getName(), cl)), false));
        //        }catch (ClassNotFoundException e) {
        //            e.printStackTrace();
        //        }
        //
        //        classPathBeanDefinitionScanner.scan("com.libra.spring.demo");
        //
        //        System.out.println("未加载");
        //        Object bean = run.getBean("studentService");
        //        if (bean != null){
        //            System.out.println("我成功了！");
        //        }

    }

}
