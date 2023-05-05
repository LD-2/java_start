package com.mirror.mybatis.test;

import com.mirror.mybatis.pojo.Car;
import com.mirror.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectAllCar {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = sqlSession.selectList("mirrorCarMapper.selectAll");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
