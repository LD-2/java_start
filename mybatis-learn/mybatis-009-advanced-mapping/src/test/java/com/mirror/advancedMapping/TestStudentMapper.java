package com.mirror.advancedMapping;

import com.mirror.advancedMapping.mapper.StudentMapper;
import com.mirror.advancedMapping.utils.pojo.Student;
import com.mirror.advancedMapping.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestStudentMapper {
    @Test
    public void testSelectById(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Student student = mapper.selectById(2);
        System.out.println(student);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById2(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Student student = mapper.selectById2(2);
        System.out.println(student);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectById3(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Student student = mapper.selectById3(1);
//        System.out.println(student);
        System.out.println(student.getSname());
        SqlSessionUtil.close(sqlSession);
    }
}
