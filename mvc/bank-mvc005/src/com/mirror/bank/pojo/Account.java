package com.mirror.bank.pojo;

/**
 * 账户实体类
 * 一张表对应一个实体类
 *
 * 属性私有 有set get方法查看属性
 * pojo对象 ：Plain Ordinary Java Object 普通的java对象 不继承实现任何类 没有业务逻辑
 * 有人会把专门封装数据的对象称为 pojo对象
 * 或者bean对象 domain对象 等等...
 */
public class Account {
    //一般这里不用基本数据类型以防查询的数据会返回空 所以用引用数据类型
    private Long id;
    private String actno;
    private Double balance;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public Account() {

    }
}
