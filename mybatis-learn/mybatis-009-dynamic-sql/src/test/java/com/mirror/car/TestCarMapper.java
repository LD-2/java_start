package com.mirror.car;


import com.mirror.car.mapper.CarMapper;
import com.mirror.car.pojo.Car;
import com.mirror.car.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCarMapper {
    @Test
    public void testSelectByMultiCondition() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        假设三个条件都不为空 select * from t_car where 1=1 and brand like "%"?"%" and guide_price > ? and car_type = ?
        List<Car> cars = mapper.selectByMultiCondition("比亚迪", 10.0, "新能源");
//        假设三个条件都是空  select * from t_car where 1=1
//        List<Car> cars = mapper.selectByMultiCondition(null, null, null);
//        假设
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithWhere() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        假设三个条件都不为空 select * from t_car where 1=1 and brand like "%"?"%" and guide_price > ? and car_type = ?
//        List<Car> cars = mapper.selectByMultiConditionWithWhere("比亚迪", 10.0, "新能源");
//        假设三个条件都是空  select * from t_car where 1=1
//        List<Car> cars = mapper.selectByMultiCondition(null, null, null);
//        假设第一个条件为空 后两个不为空  select * from t_car WHERE guide_price > ? and car_type = ?
        List<Car> cars = mapper.selectByMultiConditionWithWhere("", 10.0, "新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        假设三个条件都不为空 select * from t_car where 1=1 and brand like "%"?"%" and guide_price > ? and car_type = ?
        List<Car> cars = mapper.selectByMultiConditionWithTrim("比亚迪", 10.0, "新能源");
//        假设三个条件都是空  select * from t_car where 1=1
//        List<Car> cars = mapper.selectByMultiCondition(null, null, null);
//        假设
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdateUseSet() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(74L, null, "嘿嘿车", null, null, null);
        mapper.updateUseSet(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectUseChoose() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = mapper.selectUseChoose("", 30.0, "新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        SqlSessionUtil.close(sqlSession);
    }


    @Test
    public void tesDeleteUseForeach() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        String[] ids={"6","7","8"};
//        Double[] lala={1.0};
        Long[] ids = {6L, 7L, 8L};
        int count = mapper.deleteUseForeach(ids);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertUseForeach() {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(6L, "002", "大一", 1.0, "2002-10-01", "摇摇车"));
        cars.add(new Car(7L, "003", "大二", 2.0, "2002-10-02", "摇摇车"));
        cars.add(new Car(8L, "004", "大三", 3.0, "2002-10-03", "摇摇车"));
        int count = mapper.insertUseForeach(cars);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
    @Test
    public void testDeleteUseOr () {
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Long[] ids={78L,79L,80L};
        int count = mapper.deleteUseOr(ids);
        System.out.println(count);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

}
