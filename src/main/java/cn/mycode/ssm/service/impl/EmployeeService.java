package cn.mycode.ssm.service.impl;

import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.mapper.EmployeeMapper;
import cn.mycode.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> listAll() {
        List<Employee> employees = employeeMapper.listAll();
        return employees;
    }

    @Override
    public Employee selectOne(Long id) {
        Employee employee=employeeMapper.selectOne(id);
        return employee;
    }

    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void delete(Long id) {
        employeeMapper.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }


}
