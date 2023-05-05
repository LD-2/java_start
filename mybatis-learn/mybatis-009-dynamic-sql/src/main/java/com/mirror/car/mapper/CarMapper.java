package com.mirror.car.mapper;

import com.mirror.car.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice")Double guidePrice,@Param("carType") String carType);
    List<Car> selectByMultiConditionWithTrim(@Param("brand")String brand,@Param("guidePrice")Double guidePrice,@Param("carType")String carType);
    void updateUseSet(Car car);
    List<Car> selectUseChoose(@Param("brand")String brand,@Param("guidePrice")Double guidePrice,@Param("carType")String carType);
    int deleteUseForeach(@Param("ids") Long[] ids);
    int insertUseForeach(@Param("cars") List<Car> cars);
    int deleteUseOr(@Param("ids")Long[] ids);
}
