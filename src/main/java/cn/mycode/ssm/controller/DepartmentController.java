package cn.mycode.ssm.controller;

import cn.mycode.ssm.domain.Department;
import cn.mycode.ssm.domain.JSONResult;
import cn.mycode.ssm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;
    private ModelAndView mv=new ModelAndView();

    @RequestMapping("/list")
    @ResponseBody
    public JSONResult list(){
        List<Department> list=departmentService.listAll();

        JSONResult jsonResult=new JSONResult(true,"查询部门成功",list);

        return jsonResult;
    }

    @RequestMapping("/delete")
    @ResponseBody //把java对象转换为JSON格式
    public JSONResult testDelet(Long id){
        departmentService.deletDepar(id);
        JSONResult jsonResult=new JSONResult(true,"删除部门成功");

        return jsonResult;
    }


    @RequestMapping("/getById")
    @ResponseBody
    public JSONResult getById(Long id){
        Department department=departmentService.selectOne(id);
        JSONResult jsonResult=new JSONResult(true,"查询部门信息成功",department);

        return jsonResult;
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public JSONResult saveOrUpdate(Department dept){
        String msg="";

        if(dept!=null&&(dept.getId()!=null)){
            //编辑
            departmentService.update(dept);
            msg="编辑信息成功";
        }
        else{
            //新增
            departmentService.insert(dept);
            msg="添加信息成功";
        }
        JSONResult jsonResult=new JSONResult(true,msg,dept);
        return jsonResult;
    }
}
