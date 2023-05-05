package com.mirror.mybatis.test;

import com.mirror.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class SelectCarById {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("mirrorCarMapper.selectById", 39L);
//        sqlSession.commit();
        sqlSession.close();
        System.out.println(car);
    }
}
