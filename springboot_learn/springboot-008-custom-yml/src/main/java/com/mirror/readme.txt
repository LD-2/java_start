@Value注解
这个注解@Value("${key}") ， key 来自 application.properties(yml)
可以读取配置文件的数据 不用在类上添加@PropertySource("classpath:config.properties")
因为它 直接可以读取到properties/yml配置文件


把配置文件的数据映射为java对象
@ConfigurationProperties()
将整个文件映射称为一个对象  用于自定义配置比较多
在 com.bjpowernode.springboot.config 包下创建 SchoolInfo 类，并为该 类加上
Component 和 ConfigurationProperties 注解，prefix 可以不指定，如果不指定，那么
会去配置文件中寻找与该类的属性名一致的配置，prefix 的作用可以区分同名配置
用这个注解 还要加一个依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>


