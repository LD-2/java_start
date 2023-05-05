package com.mirror.bank.dao;

import com.mirror.bank.pojo.Account;

public interface AccountDao {
    Account selectByAct(String act);
    int updateByAct(Account act);
}
