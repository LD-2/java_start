package com.mirror.car;

import com.mirror.car.mapper.LogMapper;
import com.mirror.car.pojo.Log;
import com.mirror.car.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestLogMapper {
    @Test
    public void testSelectAll(){
        LogMapper mapper = SqlSessionUtil.openSession().getMapper(LogMapper.class);
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Log> logs = mapper.selectAll("20230215");
        logs.forEach(log -> {
            System.out.println(log);
        });
        SqlSessionUtil.close(sqlSession);
    }
}
