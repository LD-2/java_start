package com.mirror.bank.service;

import com.mirror.bank.exceptions.ActNullException;
import com.mirror.bank.exceptions.MoneyNotEnoughException;
import com.mirror.bank.exceptions.TransferException;

public interface AccountService {
    void transfer(String toact,String fromact,Double money)throws MoneyNotEnoughException, TransferException , ActNullException;
}
