package com.mirror.mybatis.test;

import com.mirror.mybatis.pojo.Car;
import com.mirror.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class CarInsert {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null,"333","比亚迪泰",30.0,"2020-11-11","新能源");
        sqlSession.insert("mirrorCarMapper.insertCar",car);
        sqlSession.commit();
        sqlSession.close();
    }
}
