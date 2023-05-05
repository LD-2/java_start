package com.mirror.bank.mapper;

import com.mirror.bank.pojo.Account;
import org.springframework.stereotype.Repository;

public interface AccountMapper {
    Account selectAccountByActno(String actno);
    int update(Account act);
}
