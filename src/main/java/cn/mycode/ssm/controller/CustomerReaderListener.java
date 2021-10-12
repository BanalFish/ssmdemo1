package cn.mycode.ssm.controller;

import cn.mycode.ssm.domain.Customer;
import cn.mycode.ssm.service.ICustomerService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class CustomerReaderListener extends AnalysisEventListener<Customer> {

    private List<Customer> customerList=new ArrayList<>();
    private ICustomerService iCustomerService;

    public CustomerReaderListener(ICustomerService iCustomerService){
        this.iCustomerService=iCustomerService;
    }

    @Override
    public void invoke(Customer customer, AnalysisContext analysisContext) {
        customerList.add(customer);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        iCustomerService.batchInsertCustomer(customerList);
    }
}
