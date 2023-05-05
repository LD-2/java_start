package com.mirror.car.mapper;

import com.mirror.car.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface CarMapper {
    Car selectCarOne(Long id);
    List<Car> selectCarAll();
//    Car selectCarByBrandLike(String brand);
    List<Car> selectCarByBrandLike(String brand);
    Map<String, Object> selectCarById(Long id);
    List<Map<String,Object>> selectCarAllMaps();
    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetMap();
    List<Car> selectAllResultMap();
    List<Car> selectMapUnderscoreToCameCase();
    Long selectCount();
    List<Car> selectCarAllUseSqlInclude();

}
