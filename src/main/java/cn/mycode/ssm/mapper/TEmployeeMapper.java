package cn.mycode.ssm.mapper;

import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.domain.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEmployeeMapper {
    int selectCount();
    List<Employee> selectEmployee(QueryObject queryObject);

    //记得加上注解，不然.xml找不到
    void batchDelete(@Param("ids") Long[] ids);

    void batchInsert(@Param("employeeList") List<Employee> employeeList);

    void insert(Employee employee);

}
