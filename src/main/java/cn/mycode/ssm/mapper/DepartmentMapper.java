package cn.mycode.ssm.mapper;

import cn.mycode.ssm.domain.Department;

import java.util.List;

public interface DepartmentMapper {

    List<Department> listAll();

    void deletDepar(Long id);

    Department selectOne(Long id);

    void update(Department dept);

    void insert(Department dept);
}
