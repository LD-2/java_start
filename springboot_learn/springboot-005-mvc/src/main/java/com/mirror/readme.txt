重要的注解
@SpringBootApplication

@SpringBootApplication 是一个复合注解
是由 @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan 联合在一起组成的。
@SpringBootConfiguration  就是 @Configuration 这个注解的功能  把当前类当作xml配置文件 配置管理bean对象的
@EnableAutoConfiguration  开启自动配置  把一些对象加入到 spring 容器中  比如mybatis 等
@ComponentScan 组件扫描器, 扫描注解, 根据注解的功能, 创建 java bean, 给属性赋值等等.
组件扫描器默认扫描的是 @ComponentScan 注解所在的类, 类所在的包和子包.


Spring Boot 的核心配置文件用于配置 Spring Boot 程序，名字必须以 application 开始




