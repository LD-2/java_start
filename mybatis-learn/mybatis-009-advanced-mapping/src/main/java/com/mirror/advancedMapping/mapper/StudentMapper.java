package com.mirror.advancedMapping.mapper;

import com.mirror.advancedMapping.utils.pojo.Student;

public interface StudentMapper {
    Student selectById(Integer sid);
    Student selectById2(Integer sid);
    Student selectById3(Integer sid);
}
