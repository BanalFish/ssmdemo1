package cn.mycode.ssm.controller;

import cn.mycode.ssm.domain.Department;
import cn.mycode.ssm.domain.Employee;
import cn.mycode.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

   @Autowired
    private IEmployeeService employeeService;
    private ModelAndView mv=new ModelAndView();

    /**
     * 查询
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView listAll(){
        List<Employee> employees = employeeService.listAll();
        mv.addObject("list",employees);
        mv.setViewName("/employee/list");
        return mv;
    }

    @RequestMapping("/input")
    public ModelAndView input(Long id){
        //编辑更新
        if(id!=null){
            Employee employee=employeeService.selectOne(id);
            mv.addObject("emp",employee);
        }
        //增加
        mv.setViewName("/employee/input");
        return mv;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Long id){
        employeeService.delete(id);

        return "redirect:/employee/list";
    }

    /**
     * 增加或者更新
     * @param emp
     * @return
     */
    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Employee emp,Long deptId){
        Department dept=new Department();
        emp.setDept(dept);
        emp.getDept().setId(deptId);
        if(emp!=null&&(emp.getId()!=null)){
            employeeService.update(emp);
        }else{
            employeeService.insert(emp);
        }

        return "redirect:/employee/list";
    }


}
