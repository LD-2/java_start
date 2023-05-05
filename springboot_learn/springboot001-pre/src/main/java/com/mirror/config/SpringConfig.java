package com.mirror.config;

import com.mirror.vo.Student;
import com.mirror.vo.Tiger;
import org.springframework.context.annotation.*;

import java.util.Date;

/**
 * Spring 使用 Xml 作为容器配置文件， 在 3.0 以后加入了 JavaConfig. 使用 java 类做配
 * 置文件使用。
 *
 * JavaConfig: 是 Spring 提供的使用 java 类配置容器。 配置 Spring IOC 容器的纯 Java 方法。
 * 优点：
 * 1.可以使用面像对象的方式， 一个配置类可以继承配置类，可以重写方法
 * 2.避免繁琐的 xml 配
 *
 * JavaConfig 主要使用的注解
 * @Configuration:放在类的上面， 这个类相当于 xml 配置文件，可以在其中声明 bean
 * @Bean:放在方法的上面， 方法的返回值是对象类型， 这个对象注入到 spring ioc 容器
 * 创建配置类（等同于 xml 配置文件）
 *
 */



/**
 * @ImportResource 是导入 xml 配置，等同于 xml 文件的 resources
 *
 * 相当于<import resource="classpath:bean.xml"/>
 */
@ImportResource({"classpath:bean.xml","classpath:applicationContext.xml"})
//加上这个注解等同于spring.xml 给spring容器配置对象的配置文件
@Configuration
/**
 * @PropertyResource
 * @PropertyResource 是读取 properties 属性配置文件
 * 在 resources 目录下创建 config.properties
 */
@PropertySource("classpath:config.properties")//这个还需要包扫描注解的对象
@ComponentScan("com.mirror.vo")
public class SpringConfig {


    /**
     * @Bean:放在方法的上面
     * 方法的返回值是对象类型  会注入到spring容器中
     * 相当于 xml文件中的 <bean id=""> <bean/>
     * id默认方法名 当然可以自己定义@Bean(name = "")
     */
    @Bean
    public Student createStudent(){
        Student student = new Student();
        student.setAge(20);
        student.setId(2);
        student.setName("ld");
        return student;
    }

    @Bean(name = "myStudent02")
    public Student createStudent02(){
        Student student = new Student();
        student.setAge(21);
        student.setId(3);
        student.setName("zjy");
        return student;
    }

    @Bean
    public Date myDate(){
        return new Date();
    }

}
