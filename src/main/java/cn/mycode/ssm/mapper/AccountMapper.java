package cn.mycode.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


public interface AccountMapper {

    void addBalance(@Param("inId")Long inId, @Param("amount")BigDecimal amount);

    void subtractBalance(@Param("outId")Long outId, @Param("amount")BigDecimal amount);
}
