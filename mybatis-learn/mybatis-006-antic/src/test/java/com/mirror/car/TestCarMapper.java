package com.mirror.car;

import com.mirror.car.mapper.CarMapper;
import com.mirror.car.pojo.Car;
import com.mirror.car.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCarMapper {
    @Test
    public void testSelectByCarType(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> pao = mapper.selectByCarsType("pao");
        pao.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAscOrDesc() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectCarsAscOrDesc("Desc");
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteBatch(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        mapper.deleteBatch("1,2,4");
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByBrandLike(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectByBrandLike("比亚迪");
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertCarUseGeneratedKeys(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null, "2002", "嘿嘿", 2.0, "1983-10-02", "哈哈车");
        int i = mapper.insertCarUseGeneratedKeys(car);
        System.out.println(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
