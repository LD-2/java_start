package com.mirror.bank.service;

import com.mirror.bank.exceptions.AppException;
import com.mirror.bank.exceptions.MoneyNotEnoughException;

public interface AccountService {
    public void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, AppException;

}
