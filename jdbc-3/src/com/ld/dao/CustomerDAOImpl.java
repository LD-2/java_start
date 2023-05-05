package com.ld.dao;

import com.ld.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
//抽象类中可以没有抽象方法，但有抽象方法的一定是抽象类 抽象类没有实例

//每一个表对应一个具体的crud实现 dao
//继承基本的curd dao
//实现自己定义的对应表的curd dao接口

public class CustomerDAOImpl extends BaseDAO<Customer> implements CustomerDAO {
    @Override
    public void inset(Connection connection, Customer customer) {
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        update(connection,sql, customer.getName(),customer.getEmail(),customer.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql="delete from customers where id=?";
        update(connection,sql,id);
    }

    @Override
    public void update(Connection connection, Customer customer) {
        String sql="update customers set name=?,email=?,birth=? where id=?";
        update(connection,sql,customer.getName(),customer.getEmail(),customer.getBirth(),customer.getId());
    }

    @Override
    public Customer getCustomerById(Connection connection, int id) {
        String sql="select id,name,email,birth from customers where id=?";
        return selectOne(connection,sql,id);
    }

    @Override
    public List<Customer> getAll(Connection connection) {
        String sql="select id,name,email,birth from customers";
        return selectList(connection,sql);
    }

    @Override
    public Long getCount(Connection connection) {
        String sql="select count(*) from customers";
        return getValue(connection,sql);
    }

    @Override
    public Date getMaxDate(Connection connection) {
        String sql="select max(birth) from customers";
        return getValue(connection,sql);
    }
}
