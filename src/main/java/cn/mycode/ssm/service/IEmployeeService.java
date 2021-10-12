package cn.mycode.ssm.service;

import cn.mycode.ssm.domain.Department;
import cn.mycode.ssm.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    //查询
    //查询所有
    List<Employee>  listAll();
    //根据员工id查询该员工信息
    Employee selectOne(Long id);

    //增加
    void insert(Employee employee);
    //删除
    void delete(Long id);
    //编辑
    void update(Employee employee);
}
