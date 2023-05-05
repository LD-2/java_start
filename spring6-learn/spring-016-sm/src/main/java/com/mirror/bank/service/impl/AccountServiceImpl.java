package com.mirror.bank.service.impl;

import com.mirror.bank.mapper.AccountMapper;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountMapper")
    private AccountMapper accountMapper;
    @Override
    public void transfer(String fromActno,String toActno,Double money) {
        Account fromAct = accountMapper.selectAccountByActno(fromActno);
        if (fromAct.getBalance()<money){
            throw new RuntimeException("余额不足");
        }
        Account toAct = accountMapper.selectAccountByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int update = accountMapper.update(fromAct);
        String str = null;
        str.toString();
        update += accountMapper.update(toAct);
        if (update != 2){
            throw new RuntimeException("未知错误");
        }
    }
}
