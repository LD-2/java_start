package com.mirror.cache.mapper;


import com.mirror.cache.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    Car selectById(Long id);
    void insertTestClass(@Param("cid") Integer cid,@Param("cname") String cname);
}
