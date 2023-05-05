package com.mirror.service.impl;

import com.mirror.dao.StudentMapper;
import com.mirror.model.Student;
import com.mirror.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public int insertStudent(Student student) {
        int rows = studentMapper.insert(student);
        int i = 10/0;
        return rows;
    }
}
