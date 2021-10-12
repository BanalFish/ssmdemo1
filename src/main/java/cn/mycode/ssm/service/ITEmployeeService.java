package cn.mycode.ssm.service;


import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.domain.EmployeeQueryObject;
import cn.mycode.ssm.domain.PageResult;
import cn.mycode.ssm.domain.QueryObject;

import java.util.List;

public interface ITEmployeeService {


    //返回数据集，便于分页
     PageResult<Employee> queryEmployeeByPage(QueryObject queryObject);

    void batchDeleteEmployee(Long[] ids);

    void batchInsertEmployee(List<Employee> employeeList);

    List<Employee> queryEmployeeList(EmployeeQueryObject queryObject);

    void insert(Employee employee);
}
