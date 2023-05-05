package com.mirror.car.mapper;

import com.mirror.car.pojo.Log;

import java.util.List;

public interface LogMapper {
     List<Log> selectAll(String num);
}
