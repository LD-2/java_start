package com.mirror;

import com.mirror.mybatis.pojo.Car;
import com.mirror.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test2 {

    @Test
    public void testMapInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map = new HashMap<>();
        map.put("k1","1111");
        map.put("k2","比亚迪汉");
        map.put("k3",10.0);
        map.put("k4","2023-1-19");
        map.put("k5","电车");
        sqlSession.insert("insertCar-typeMap",map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testByUtils(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        sqlSession.insert("mirrorCarMapper.insertCar");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test() {
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        try (

                InputStream is = Resources.getResourceAsStream("mybatis-config.xml")
//                InputStream is =Resources.getResourceAsStream("com/mybatis-config.xml")
//                InputStream is=new FileInputStream("E:\\java-projects\\mybatis-learn\\mybatis01\\src\\main\\resources\\mybatis-config.xml")
//                InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        ) {
            //mybatis核心配置文件路径  这个方法正好默认根路径开始找
            //获取SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);//一般都是一个数据库对应一个SqlSessionFactory对象
            //获取SqlSession对象
//            SqlSession sqlSession=sqlSessionFactory.openSession(true);
            SqlSession sqlSession=sqlSessionFactory.openSession();
            //执行SQL语句
            int count = sqlSession.insert("insertCar");//找映射mapper中的namespace对应的sql语句
            System.out.println("插入记录条数: "+count);
            //mybatis的SqlSession对象默认情况下不会自动提交
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
