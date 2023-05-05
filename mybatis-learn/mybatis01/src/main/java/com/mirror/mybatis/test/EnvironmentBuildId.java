package com.mirror.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EnvironmentBuildId {
    public static void main(String[] args) throws Exception {
//        不加环境id的话用默认的环境
//        加了环境id的话使用指定的环境连接数据库
        SqlSession sqlSession1 = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        SqlSession sqlSession2 =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"),"mirrorDB").openSession();
        System.out.println(sqlSession1);
        System.out.println(sqlSession2);
    }
}
