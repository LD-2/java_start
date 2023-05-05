package com.mirror.dao;


import com.mirror.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao {
    Student selectById(Integer id);
}
