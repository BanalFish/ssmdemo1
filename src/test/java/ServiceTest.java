import cn.mycode.ssm.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
//@MapperScan("cn.mycode.ssm.mapper")
public class ServiceTest {

    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void test(){
        accountService.transfer(1L,2L,new BigDecimal("100"));
    }

}
