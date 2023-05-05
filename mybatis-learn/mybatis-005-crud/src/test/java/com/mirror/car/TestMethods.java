package com.mirror.car;

import com.mirror.car.mapper.CarMapper;
import com.mirror.car.pojo.Car;
import com.mirror.car.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMethods {

    private CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
    private SqlSession sqlSession = SqlSessionUtil.openSession();
    @Test
    public void testInsert(){
        mapper.insert(new Car(null,"7s18","mm",100.00,"2023.1.2","pao"));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void  testDelete(){
        mapper.deleteById(70L);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdate(){
        mapper.update(new Car(3L,"7s18","mm",100.00,"2023.1.2","pao"));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectOne(){
        Car car = mapper.selectOne(3L);
        System.out.println(car);
    }

    @Test
    public void testSelectAll(){
        for (Car car : mapper.selectAll()) {
            System.out.println(car);
        }
    }

}
