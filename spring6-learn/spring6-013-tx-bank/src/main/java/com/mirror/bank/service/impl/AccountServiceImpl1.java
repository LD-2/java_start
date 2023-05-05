package com.mirror.bank.service.impl;

import com.mirror.bank.dao.AccountDao;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("act1")
@Transactional
public class AccountServiceImpl1 implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Resource(name = "act2")
    private AccountServiceImpl2 act2;

//    因为底层的事务是AOP的原理 面向切面编程 所以 上一个方法 } 结束才提交事务
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act){
        int insert = accountDao.insert(act);
        if(insert == 1) System.out.println("service1插入成功");
        else System.out.println("service1插入失败");
//        new AccountServiceImpl2().save(new Account("act004",20.00));
        try {
            act2.save(new Account("act004",20.00));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
