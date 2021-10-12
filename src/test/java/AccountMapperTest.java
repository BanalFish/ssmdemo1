import cn.mycode.ssm.mapper.AccountMapper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void addTest() {
        Logger.getLogger("org.apache.spark").setLevel(Level.ERROR);
        Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF);
        accountMapper.addBalance(1L, new BigDecimal("100"));
    }
}
