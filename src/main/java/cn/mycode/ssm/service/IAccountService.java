package cn.mycode.ssm.service;

import java.math.BigDecimal;

public interface IAccountService {

    void transfer(Long outId, Long inId, BigDecimal amount);
}
