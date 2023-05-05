package com.mirror.bank.dao.impl;

import com.mirror.bank.dao.AccountDao;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByAct(String act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        Account account = sqlSession.selectOne("BankMapper.selectByAct", act);
//        sqlSession.close();
        return sqlSession.selectOne("BankMapper.selectByAct", act);
    }

    @Override
    public int updateByAct(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        int count = sqlSession.update("BankMapper.updateByAct", act);
//        sqlSession.commit();
//        sqlSession.close();
        return sqlSession.update("BankMapper.updateByAct", act);
    }
}
