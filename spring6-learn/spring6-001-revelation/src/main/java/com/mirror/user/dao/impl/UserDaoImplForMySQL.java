package com.mirror.user.dao.impl;

import com.mirror.user.dao.UserDao;
import com.mirror.user.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

public class UserDaoImplForMySQL implements UserDao {
    @Override
    public User selectUser(String username, String password) throws Exception{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User(username, password);
        User user1 = (User) sqlSession.selectOne("com.mirror.user.mapper.UserMapper.selectUser", user);
        sqlSession.close();
        return user1;
    }
}
