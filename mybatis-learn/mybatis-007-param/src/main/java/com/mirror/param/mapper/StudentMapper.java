package com.mirror.param.mapper;

import com.mirror.param.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);
    void insertStudentByMap(Map<String,Object> map);
    void insertStudentByPojo(Student student);
    List<Student> selectStudentByNameAndSex(String name,Character sex);
    List<Student> selectStudentByNameAndSexParam(@Param("name") String name,@Param("sex") Character sex);
}
