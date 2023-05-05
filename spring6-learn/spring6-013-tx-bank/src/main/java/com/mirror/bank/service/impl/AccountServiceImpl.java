package com.mirror.bank.service.impl;

import com.mirror.bank.dao.AccountDao;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void save(Account act) {

    }

    @Override
    public void transfer(String fromActno, String toActno, double money) {

        //查询余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        //账户余额不足
        if(fromAct.getBalance() < money){
            throw new RuntimeException("账户余额不足");
        }
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        int update = accountDao.update(fromAct);

        String s = null;
        s.toString();

        update += accountDao.update(toAct);
        // 模拟异常
        if (update != 2){
            throw new RuntimeException("转账失败，请联系银行");
        }
    }

}
