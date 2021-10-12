package cn.mycode.ssm.service;

import cn.mycode.ssm.domain.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> listAll();

    void deletDepar(Long id);

    Department selectOne(Long id);

    void update(Department dept);

    void insert(Department dept);
}
