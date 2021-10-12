import cn.mycode.ssm.domain.Department;
import cn.mycode.ssm.service.impl.DepartmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")

public class DepartmentTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Test
    public void listTest(){
        List<Department> departments=departmentService.listAll();

        for(Department d:departments){
            System.out.println(d);
        }

    }


}
