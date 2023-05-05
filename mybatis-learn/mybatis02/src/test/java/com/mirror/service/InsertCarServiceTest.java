package com.mirror.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class InsertCarServiceTest {
    /**
     * 单元测试: 你要测试的类名+Test  规范
     * 一般是一个业务方法对应一个测试方法
     * 测试方法命名规范test+方法名
     * 注意规范只是规范，并非一定这样
     * @Test注解很重要，被此注解标注的方法就是一个单元测试方法
     * 单元测试方法无参，无返回值
     */
    @Test
    public void insertTest(){
        SqlSession sqlSession=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            sqlSession.commit();
        } catch (IOException e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
