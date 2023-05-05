package com.mirror.car.mapper;

import com.mirror.car.pojo.Car;

import java.util.List;

public interface CarMapper {
    void insert(Car car);
    void deleteById(Long id);
    void update(Car car);
    Car selectOne(Long id);
    List<Car> selectAll();
}
