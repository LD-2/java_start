@MapperScan 放到主启动类上
@MapperScan(basePackages = {"com.mirror.dao"})
此注解可以去扫描指定的包 从而动态代理创建对象


在application.properties 配置文件中指定映射文件的位置
这个配置只有接口和映射文件不在同一个包的情况下，才需要指定。

#配置mapper xml文件的路径
mybatis.mapper-locations=classpath:mapper/*.xml
#配置显示日志
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

