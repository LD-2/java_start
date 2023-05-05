package com.mirror.mybatis.test;

import com.mirror.mybatis.pojo.Car;
import com.mirror.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UpdateById {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("mirrorCarMapper.updateById",new Car(39L,"2","玩具车",22.00,"2023-2-1","自制"));
        sqlSession.commit();
        System.out.println(count);
        sqlSession.close();
    }
}
