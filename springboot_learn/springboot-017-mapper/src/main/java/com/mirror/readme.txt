ORM操作MySql
使用Mybatis框架操作数据库 在SpringBoot框架继承MyBatis

使用步骤
   1 mybatis起步依赖: 完成mybatis对象自动配置,对象放在容器中
   2 pom.xml文件把src/main/java目录中的xml文件包含到classpath中
   3 创建实体类Student
   4 创建Dao接口 创建一个 查询学生的方法
   5 创建Dao接口对应的Mapper文件 xml文件处理sql语句
   6 创建Service对象 创建其实现类 调用mapper接口中的方法完成业务逻辑的执行
   7 创建Controller对象 访问service层
   8 写application.properties文件
     配置数据库的连接信息

第一种方式 @Mapper: 放在dao接口上面,每个接口都需要这个注解
@Mapper接口告诉mybatis这个是dao接口 创建此接口的代理对象
位置在类的上面
@Mapper的缺陷就是 如果类比较多 那么就每个类上都要 写一个@Mapper

第二种
因此就有了 @MapperScan  是用来扫描dao接口的 这个接口只用
放在主启动类上 并且提供需要扫描的包名就行了


