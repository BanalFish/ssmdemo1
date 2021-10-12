package cn.mycode.ssm.service.impl;

import cn.mycode.ssm.domain.Department;
import cn.mycode.ssm.mapper.DepartmentMapper;
import cn.mycode.ssm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> listAll() {
        List<Department> departments=departmentMapper.listAll();
        return departments;
    }


    public void deletDepar(Long id){
        departmentMapper.deletDepar(id);
    }

    public Department selectOne(Long id){
        Department department=departmentMapper.selectOne(id);
        return department;
    }

    @Override
    public void update(Department dept) {
        departmentMapper.update(dept);
    }

    @Override
    public void insert(Department dept) {
        departmentMapper.insert(dept);
    }

}
