package com.mirror.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.InputStream;

public class FirstTest {
    public static void main(String[] args) {
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
