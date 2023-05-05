package com.mirror.bank.utils;

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

    //全局的 服务器级别的 一个服务器中定义一个
    //为什么把SqlSession对象放到ThreadLocal中 为了保证一个线程对应一个SqlSession对象
    private static ThreadLocal<SqlSession> local=new ThreadLocal<>();
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
//        return sqlSessionFactory.openSession();
        return local.get();
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
            local.remove();
        }
    }
}
