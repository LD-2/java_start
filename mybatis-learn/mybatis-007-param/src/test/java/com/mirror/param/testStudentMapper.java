package com.mirror.param;

import com.mirror.param.mapper.StudentMapper;
import com.mirror.param.pojo.Student;
import com.mirror.param.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testStudentMapper {

    @Test
    public void testSelectById(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Student> students = mapper.selectById(2L);
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void  testSelectByName(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Student> students = mapper.selectByName("mirror");
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByBirth()throws Exception{
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth=dateFormat.parse("2002-10-23");
        List<Student> students = mapper.selectByBirth(birth);
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }
    
    @Test
    public void  testSelectBySex(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Character sex=Character.valueOf('女');
        List<Student> students = mapper.selectBySex(sex);
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByMap(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String,Object> map=new HashMap<>();
        map.put("name","拉拉");
        map.put("age",3);
        map.put("height",1.65);
        map.put("birth",new Date());
        map.put("sex",'女');
        mapper.insertStudentByMap(map);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByPojo(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        mapper.insertStudentByPojo(new Student(null,"ld",23,1.7,new Date(),'女'));
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByNameAndSex(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Student> students = mapper.selectStudentByNameAndSex("mirror", '男');
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByNameAndSexParam(){
        StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Student> students = mapper.selectStudentByNameAndSexParam("mirror", '男');
        students.forEach(student -> {
            System.out.println(student);
        });
        SqlSessionUtil.close(sqlSession);
    }
}
