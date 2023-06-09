package com.mirror.bean;

import javax.xml.crypto.Data;
import java.sql.Date;

/**
 * @Description ORM思想(object relationship mapping)
 * 一张表对应一个java类
 * 一条记录对应一个对象
 * 一个字段对应一个属性
 */

public class Customer {
    private int id;
    private String name;
    private String email;
    private java.sql.Date birth;

    public Customer() {
    }

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return birth;
    }

    public void setData(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
