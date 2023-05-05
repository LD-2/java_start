package com.mirror.mybatis.test;

import com.mirror.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class deleteCarById {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteCarById", 42L);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);
    }
}
