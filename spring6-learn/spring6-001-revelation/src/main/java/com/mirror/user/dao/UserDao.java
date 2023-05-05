package com.mirror.user.dao;

import com.mirror.user.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User selectUser(String username,String password)throws Exception;

}
