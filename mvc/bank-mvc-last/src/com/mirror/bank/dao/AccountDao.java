package com.mirror.bank.dao;

import com.mirror.bank.pojo.Account;

import java.util.List;

public interface AccountDao {
    public int insert(Account account);
    public int deleteById(Long id);
    public int update(Account account);
    public Account selectByActno(String actno);
    public List<Account> selectList();
}
