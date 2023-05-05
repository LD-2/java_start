package com.mirror.mvc;

import com.mirror.exceptions.AppException;
import com.mirror.exceptions.MoneyNotEnoughException;
import com.mirror.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *  业务类一般起名 XxxService  XxxBiz
 *  处理不同表的业务 创建不同的业务类
 *
 *  DAO不写成静态 类似工具类的原因
 *  DAO操纵的数据很多，为了避免不必要的方法加载占用JVM空间，浪费堆空间。
 *
 *
 *  事务一定是在Service层进行控制的，一般是一个业务对应一个完整的事务
 *  一般是一个业务方法对应一个完整的事务 但是不排除方法之间调用的情况
 *  每一个事务对应一个完整的业务流程
 *  Service类中的每一个方法 就是一个完整的业务流程
 *
 *  代理模式 动态代理模式
 */

public class AccountService {

    //为什么要定义到这里 因为每一个业务方法中都可能需要连接数据库 对此表进行 crud操作
    private AccountDao accountDao = new AccountDao();
    //这里方法起名 要体现出处理的业务是什么
    // 这里要提供一个能实现转账的业务方法 （一个业务对应一个方法）
    public void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, AppException {
        //Service层控制事务
        //开启事务（需要使用Connection对象）
        try(Connection connection = JDBCUtil.getConnection()){
            //关闭自动提交
            connection.setAutoCommit(false);
            //先查询数据库中此表的对象 余额是否够
            Account fromAct = accountDao.selectByActno(fromActno);
            Double balanceA = fromAct.getBalance();
            if(balanceA<money){
                //余额不够的话 就报余额不够 异常
                throw new MoneyNotEnoughException("余额不足...");
            }
            //程序到这里 说明余额充足
            Account toAct = accountDao.selectByActno(toActno);
            //修改余额
            fromAct.setBalance(fromAct.getBalance()-money);
            toAct.setBalance(toAct.getBalance()+money);
            //更改数据库中的余额
            int count = accountDao.update(fromAct);

//            System.out.println(10/0);

            count += accountDao.update(toAct);
            if(count!=2){
                throw new AppException("账户转账异常...");
            }
            //提交事务
            connection.commit();
        }catch (SQLException e){
            //这里只捕获SQLException 以防其它异常抛不出去
            //回滚事务

            throw new AppException("账户转账异常...");
        }
    }
}
