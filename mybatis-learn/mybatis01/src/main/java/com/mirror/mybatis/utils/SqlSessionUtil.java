package com.mirror.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtil {
    //工具类的构造方法一般私有化
    //工具类中的所有方法都是静态的 直接用类名调用，不用new对象
    //为了防止new对象构造方法私有化
    private SqlSessionUtil(){}
    private static SqlSessionFactory sqlSessionFactory= null;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
