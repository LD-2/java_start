package com.mirror.bank.service.impl;

import com.mirror.bank.dao.AccountDao;
import com.mirror.bank.dao.impl.AccountDaoImpl;
import com.mirror.bank.exceptions.ActNullException;
import com.mirror.bank.exceptions.MoneyNotEnoughException;
import com.mirror.bank.exceptions.TransferException;
import com.mirror.bank.pojo.Account;
import com.mirror.bank.service.AccountService;
import com.mirror.bank.utils.GenerateDaoProxy;
import com.mirror.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
//    private AccountDao accountDaoImpl = new AccountDaoImpl();
//    private AccountDao accountDao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);
    //在mybatis当中，mybatis提供了相关的机制。也可以动态为我们生成dao接口的实现类。(代理类：dao接口的代理）
    //mybatis当中实际上采用了代理模式。在内存中生成dao接口的代理类，然后创建代理类的实例。
    //使用mybatis的这种代理机制的前提: SqLMapper.xmL文件中namespace必须是dao接口的全限定名称,id必须是dao接口中的方法名。、
    private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);
    @Override
    public void transfer(String toact, String fromact, Double money) throws MoneyNotEnoughException ,TransferException ,ActNullException{
        SqlSession sqlSession= SqlSessionUtil.openSession();

        //判断余额是否充足
        //需要查询转出账户的余额 select操作        //如果充足则更新两个账户的余额 执行update操作
        Account actfrom = accountDao.selectByAct(fromact);
        Account actto = accountDao.selectByAct(toact);
        if(actfrom==null||actto==null){
            //用户不存在
            throw  new ActNullException("用户不存在");
        }else{
            //用户存在
            if(actfrom.getBalance()>=money){
                //余额充足 进行 更新操作
                actfrom.setBalance(actfrom.getBalance()-money);
                actto.setBalance(actto.getBalance()+money);
                int count = accountDao.updateByAct(actfrom);

                //模拟空指针异常
//                String s=null;
//                s.toString();

                count += accountDao.updateByAct(actto);
                if(count != 2){
                    //转账失败异常
                    throw new TransferException("转账失败，原因未知.");
                }
            }else{
                //余额不足
                throw new MoneyNotEnoughException("对不起，余额不足.");
            }
            //事务的处理要在业务逻辑层
            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);

        }
    }
}
