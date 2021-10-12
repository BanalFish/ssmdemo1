package cn.mycode.ssm.mapper;

import cn.mycode.ssm.domain.Customer;
import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.domain.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    //查询总数量
    int selectCount();
    //返回集合
    List<Customer> selectCustomer(QueryObject queryObject);

    //批量删除
    void batchDelete(@Param("ids") Long[] ids);//记得加上注解，不然.xml找不到

    //批量增加
    void batchInsert(@Param("customerList") List<Customer> customerList);

    //单个增加
    void insert(Customer customer);
}
