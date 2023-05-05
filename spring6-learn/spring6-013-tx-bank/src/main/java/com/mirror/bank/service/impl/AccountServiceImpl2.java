package com.mirror.bank.service.impl;

import com.mirror.bank.dao.AccountDao;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("act2")
@Transactional
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;
    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account act){
        int insert = accountDao.insert(act);
        String str = null;
        str.toString();
        if(insert == 1) System.out.println("service2插入成功");
        else System.out.println("service2插入失败");
    }
}
