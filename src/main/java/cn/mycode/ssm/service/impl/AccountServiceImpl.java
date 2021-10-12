package cn.mycode.ssm.service.impl;

import cn.mycode.ssm.mapper.AccountMapper;
import cn.mycode.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service//告诉spring即将创建impl实例的名字是impl前面的，这样spring自动创建
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;



    @Transactional//表明此下的方法都要添加事务管理
    @Override
    public void transfer(Long outId, Long inId, BigDecimal amount) {
        accountMapper.addBalance(inId,amount);
       // int i=10/0;
        accountMapper.subtractBalance(outId,amount);
    }
}
