package com.mirror.car.mapper;

import com.mirror.car.pojo.Car;

import java.util.List;

public interface CarMapper {

    List<Car> selectByCarsType(String CarType);

    List<Car> selectCarsAscOrDesc(String ascOrDesc);

    void deleteBatch(String ids);

    List<Car> selectByBrandLike(String brand);

    int insertCarUseGeneratedKeys(Car car);
}
