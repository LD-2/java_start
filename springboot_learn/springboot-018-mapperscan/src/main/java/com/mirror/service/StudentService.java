package com.mirror.service;

import com.mirror.model.Student;

public interface StudentService {
    Student queryStudent(Integer id);
    int insertStudent(Student student);
}
