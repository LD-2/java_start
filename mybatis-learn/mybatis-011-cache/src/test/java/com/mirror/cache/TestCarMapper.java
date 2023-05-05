package com.mirror.cache;

import com.mirror.cache.mapper.CarMapper;
import com.mirror.cache.pojo.Car;
import com.mirror.cache.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestCarMapper {
    @Test
    public void testSelectById1(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car1 = mapper.selectById(3L);
        System.out.println(car1);
        Car car2 = mapper.selectById(3L);
        System.out.println(car2);
        SqlSessionUtil.close(sqlSession);
    }
    @Test
    public void testSelectById2() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(3L);
        System.out.println(car1);
        Car car2 = mapper2.selectById(3L);
        System.out.println(car2);
        sqlSession1.close();
        sqlSession2.close();
    }

//    什么情况下 会不走一级缓存
//    SqlSession对象不是同一个
//    查询条件不一样

//    什么时候一级缓存失效
//    第一次DQL和第二次DQL语句之间 手动清除缓存sqlSession.clearCache() 手动清除缓存
//    或者执行了insert update delete 中的任意一条且不分表
    @Test
    public void testInvalid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper1 = sqlSession.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(3L);
        System.out.println(car1);
//        手动清除缓存
//        sqlSession.clearCache();
//        执行 i d u 任意表
        mapper1.insertTestClass(1003,"666班");
        sqlSession.commit();
        Car car2 = mapper2.selectById(3L);
        System.out.println(car2);
        SqlSessionUtil.close(sqlSession);
    }

//    二级缓存的范围是SqlSessionFactory。
//    使用二级缓存需要具备以下几个条件：
//    1. <setting name="cacheEnabled" value="true">全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。默认就是true，无需设置。
//    2,在需要使用二级缓 SqlMapper.xml文件中添加配置: <cache/>
//    3,使用二级缓存的实体类对象必须是可序列化的,也就是必须实现java.io.Serializable接口
//    4. SqlSession对象关闭或提交之后,一级缓存中的数据才会被写入到二级缓存当中。此时二级缓存才可用。测试二级缓存：
//    二级缓存的失效：只要两次查询之间出现了增删改操作。二级缓存就会失效。【一级缓存也会失效】
//    二级缓存的相关配置：
//    1. eviction：指定从缓存中移除某个对象的淘汰算法。
//         默认采用LRU策略。
//         a. LRU: Least Recently Used。最近最少使用。优先淘汰在间隔时间内使用频率最低的对象。(其实还有一种淘汰算法LFU，最不常用。）
//         b. FIFO: First In First Out。一种先进先出的数据缓存器。先进入二级缓存的对象最先被淘汰。
//         c.SOFT：软引用。淘汰软引用指向的对象。具体算法和JVM的垃圾回收算法有关。
//         d.WEAK：弱引用。淘汰弱引用指向的对象。具体算法和JVM的垃圾回收算法有关。
//    2. flushInterval:a.二级缓存的刷新时间间隔。单位毫秒。如果没有设置。就代表不刷新缓存,只要内存足够大,一直会向二级缓存中缓存数据。除非执行了增删改。
//    3. readOnly:
//         a.true：多条相同的sql语句执行之后返回的对象是共享的同一个。性能好。但是多线程并发可能会存在安全问题。
//         b.false：多条相同的sql语句执行之后返回的对象是副本，调用了clone方法。性能一般。但安全。
//    4. size:a.设置二级缓存中最多可存储的java对象数量。默认值1024。
    @Test
    public void testSecond_level_cache() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(3L);
        System.out.println(car1);
        sqlSession1.close();
        Car car2 = mapper2.selectById(3L);
        System.out.println(car2);
        sqlSession2.close();
    }

    @Test
    public void testSelectById22() throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(83L);
        System.out.println(car1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(83L);
        System.out.println(car2);
    }
}
