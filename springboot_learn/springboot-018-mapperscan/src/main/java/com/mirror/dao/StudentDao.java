package com.mirror.dao;


import com.mirror.model.Student;
import org.apache.ibatis.annotations.Mapper;


public interface StudentDao {
    Student selectById(Integer id);
    int insert(Student row);

}
