package com.mirror.service.impl;

import com.mirror.dao.StudentDao;
import com.mirror.model.Student;
import com.mirror.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryStudent(Integer id) {
        return studentDao.selectById(id);
    }
}
