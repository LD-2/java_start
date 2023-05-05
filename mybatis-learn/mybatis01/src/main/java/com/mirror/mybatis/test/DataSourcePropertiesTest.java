package com.mirror.mybatis.test;
import com.mirror.mybatis.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSourcePropertiesTest  {
    public static void main(String[] args) throws Exception{
        SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
//        这里记得一个sqlSessionFactory对象对应environment   对应一个dataSource所以对应对应一个数据库  对应这个连接池的属性设置
        for (int i = 0; i < 4; i++) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("mirrorCarMapper.insertCar",new Car(null,"22","datasource测试",30.0,"2020-11-11","新能源"));
//            sqlSession.commit();
        }
    }
}
