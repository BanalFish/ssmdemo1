package cn.mycode.ssm.service.impl;

import cn.mycode.ssm.domain.*;
import cn.mycode.ssm.mapper.CustomerMapper;
import cn.mycode.ssm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private List<Customer> customerList=new ArrayList<>();
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public PageResult<Customer> queryCustomerByPage(QueryObject queryObject){
        PageResult<Customer> pageResult=null;
        int totalCount=customerMapper.selectCount();

        if(totalCount==0){
            pageResult=new PageResult<>(queryObject.getCurrentPage(), queryObject.getPageSize(),
                    0,new ArrayList<Customer>());
        }else{
            pageResult=new PageResult<>(queryObject.getCurrentPage(),queryObject.getPageSize(),
                    totalCount,customerMapper.selectCustomer(queryObject));
        }

        return pageResult;
    }

    @Override
    public void batchDeleteCustomer(Long[] ids) {
        customerMapper.batchDelete(ids);
    }

    @Override
    public void batchInsertCustomer(List<Customer> customerList) {
        customerMapper.batchInsert(customerList);
    }

    @Override
    public List<Customer> queryCustomerList(CustomerQueryObject queryObject) {
        return customerMapper.selectCustomer(queryObject);
    }

    @Override
    public void insert(Customer customer) {
        customerMapper.insert(customer);
    }


}
