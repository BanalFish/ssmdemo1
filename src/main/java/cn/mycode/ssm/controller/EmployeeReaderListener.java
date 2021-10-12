package cn.mycode.ssm.controller;

import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.service.ITEmployeeService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class EmployeeReaderListener extends AnalysisEventListener<Employee> {

    private List<Employee> employeeList=new ArrayList<>();
    private ITEmployeeService itEmployeeService;

    public EmployeeReaderListener(ITEmployeeService itEmployeeService) {
        this.itEmployeeService = itEmployeeService;
    }

    //每读excel一行数据，就调用一次这个方法
    @Override
    public void invoke(Employee employee, AnalysisContext analysisContext) {
        employeeList.add(employee);
        //通过employee里的注解封装成employee对象
    }

    //把Excel工作表读完之后调用
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(employeeList);
        //保存数据库
        //不从第一行（表头）读
        itEmployeeService.batchInsertEmployee(employeeList);
    }
}
