package com.mirror.car;

import com.mirror.car.mapper.CarMapper;
import com.mirror.car.pojo.Car;
import com.mirror.car.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestCarMapper {
    @Test
    public void testSelectCarOne(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = mapper.selectCarOne(3L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAll(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectCarAll();
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectCarByLike(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        TooManyResultsException
//        Car car = mapper.selectCarByBrandLike("比亚迪");
//        System.out.println(car);
        List<Car> cars = mapper.selectCarByBrandLike("比亚迪");
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectCarById(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Object> car = mapper.selectCarById(38L);
        System.out.println(car);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectCarAllMaps(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Map<String, Object>> maps = mapper.selectCarAllMaps();
        maps.forEach(map->{
            System.out.println(map);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllRetMap() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<Long, Map<String, Object>> maps = mapper.selectAllRetMap();
        System.out.println(maps);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllResultMap(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectAllResultMap();
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectMapUnderscoreToCameCase(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectMapUnderscoreToCameCase();
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectCount(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Long count = mapper.selectCount();
        System.out.println(count);
        SqlSessionUtil.close(sqlSession);

    }

    @Test
    public void  testSelectCarAllUseSqlInclude(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectCarAllUseSqlInclude();
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }
}
