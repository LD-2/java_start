package com.mirror.bank.service;

import com.mirror.bank.pojo.Account;

public interface AccountService {
    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param money
     */
    void transfer(String fromActno, String toActno, double money);
    void save(Account act);
}
