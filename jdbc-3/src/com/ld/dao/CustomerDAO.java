package com.ld.dao;

import com.ld.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

//每一个表有一个规范自己curd的接口

//此接口用于规范对于customers表的常用操作
public interface CustomerDAO {
    //public abstract

    //向表中插入一条记录  一条记录对应一个对象
    void inset(Connection connection, Customer customer);

    //根据id删除表中的某条记录
    void deleteById(Connection connection,int id);

    //修改表中的某条记录 一条记录对应一个对象
    void update(Connection connection, Customer customer);

    //根据id查询某一条记录 一条记录对应一个对象
    Customer getCustomerById(Connection connection, int id);

    //查询所有记录
    List<Customer> getAll(Connection connection);

    //查询表中记录数量
    Long getCount(Connection connection);

    //查询最大的出生日期
    Date getMaxDate(Connection connection);
}
