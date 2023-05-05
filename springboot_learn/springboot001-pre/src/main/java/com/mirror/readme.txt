也就是说这里有大体这几个注解
@Configuration 表示了此文件就是 spring.xml文件
@Bean 这个注解 代替了 原来spring.xml文件中的<bean></bean>标签
@ImportResource 这个注解相当远 原来xml文件中的 <import resource="classpath:bean.xml"/> 导入其它xml文件用的
@PropertySource("classpath:config.properties") 向xml文件中导入properties文件的 原来xml文件中也有
@ComponentScan("com.mirror.vo") 扫描注解管理的bean对象的注解 扫描包的 原来也在xml中


