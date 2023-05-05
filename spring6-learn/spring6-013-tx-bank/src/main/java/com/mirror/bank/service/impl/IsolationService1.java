package com.mirror.bank.service.impl;

import com.mirror.bank.dao.AccountDao;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {
    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    // 1号
    // 负责查询
    // 当前事务可以读取到别的事务没有提交的数据。
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    // 对方事务提交之后的数据我才能读取到。
//    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息：" + account);
    }
}
