package cn.mycode.ssm.service;

import cn.mycode.ssm.domain.Customer;
import cn.mycode.ssm.domain.CustomerQueryObject;
import cn.mycode.ssm.domain.PageResult;
import cn.mycode.ssm.domain.QueryObject;

import java.util.List;

public interface ICustomerService {

    PageResult<Customer> queryCustomerByPage(QueryObject queryObject);

    void batchDeleteCustomer(Long[] ids);

    void batchInsertCustomer(List<Customer> customerList);

    List<Customer> queryCustomerList(CustomerQueryObject queryObject);

    void insert(Customer customer);
}
