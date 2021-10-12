package cn.mycode.ssm.service.impl;

import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.domain.EmployeeQueryObject;
import cn.mycode.ssm.domain.PageResult;
import cn.mycode.ssm.domain.QueryObject;
import cn.mycode.ssm.mapper.TEmployeeMapper;
import cn.mycode.ssm.service.ITEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ITEmployeeServiceImpl implements ITEmployeeService {

    private List<Employee> employeeList=new ArrayList<>();
    @Autowired
    private TEmployeeMapper tEmployeeMapper;

    @Override
    public PageResult<Employee> queryEmployeeByPage(QueryObject queryObject) {
        PageResult<Employee> pageResult=null;
        int totalCount=tEmployeeMapper.selectCount();

        if(totalCount==0){
            pageResult=new PageResult<>(queryObject.getCurrentPage(), queryObject.getPageSize(),
                   0,new ArrayList<Employee>());
        }else{
            pageResult=new PageResult<Employee>(queryObject.getCurrentPage(),
                    queryObject.getPageSize(), totalCount,tEmployeeMapper.selectEmployee(queryObject));
        }

        return pageResult;
    }

    @Override
    public void batchDeleteEmployee(Long[] ids){
        tEmployeeMapper.batchDelete(ids);
    }

    @Override
    public void batchInsertEmployee(List<Employee> employeeList){
        tEmployeeMapper.batchInsert(employeeList);
    }

    public List<Employee> queryEmployeeList(EmployeeQueryObject queryObject){
        return tEmployeeMapper.selectEmployee(queryObject);
    }

    public void insert(Employee employee){
        tEmployeeMapper.insert(employee);
    }
}
