package cn.mycode.ssm.controller;

import cn.mycode.ssm.domain.*;
import cn.mycode.ssm.service.ITEmployeeService;
import cn.mycode.ssm.service.impl.DepartmentServiceImpl;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/temployee")
public class TEmployeeController {

    @Autowired
    private ITEmployeeService itEmployeeService;

    @RequestMapping("/list")
    @ResponseBody
    public JSONResult list(@ModelAttribute("qo") QueryObject queryObject){
        PageResult<Employee> employeePageResult = itEmployeeService.queryEmployeeByPage(queryObject);
        JSONResult jsonResult=new JSONResult(true,"查询员工信息成功",employeePageResult);

        return jsonResult;
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public JSONResult batchDelete(Long[] ids){
        itEmployeeService.batchDeleteEmployee(ids);
        JSONResult jsonResult=new JSONResult(true,"批量删除员工信息成功");

        return jsonResult;
    }


    @RequestMapping("/import")
    @ResponseBody
    public JSONResult importData(MultipartFile pic) throws Exception{
        JSONResult jsonResult=null;

            System.out.println(pic.getOriginalFilename());
            System.out.println(pic.getInputStream());

            //创建工作簿
            ExcelReaderBuilder workBook= EasyExcel.read(pic.getInputStream(),
                    Employee.class,new EmployeeReaderListener(itEmployeeService));
            //创建工作表
            //按照顺序读，默认从0开始
            ExcelReaderSheetBuilder sheet1=workBook.sheet();
            //读excel
            sheet1.doRead();

            jsonResult=new JSONResult(true,"导入数据成功");

        return jsonResult;
    }

    @RequestMapping("/export")
    @ResponseBody
    public void exportData(EmployeeQueryObject queryObject, HttpServletResponse response) throws Exception{


            queryObject.setPageSize(null);
            List<Employee> employeeList= itEmployeeService.queryEmployeeList(queryObject);

            //设置服务器发送给浏览器的数据类型
            response.setContentType("application/vnd.ms-excel");
            //设置编码
            response.setCharacterEncoding("UTF-8");
            //设置文件名编码
            String fileName= URLEncoder.encode("员工数据表","UTF-8");
            //设置http header
            response.setHeader("Content-disposition","attachment;filename="+fileName+".xls");
            //创建工作薄对象
            ExcelWriterBuilder workbook = EasyExcel.write(response.getOutputStream(), Employee.class);
            //创建工作表对象
            ExcelWriterSheetBuilder sheet = workbook.sheet("员工数据表");
            //写excel
            sheet.doWrite(employeeList);


    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(Employee employee){
        //模拟异常
        //int i=10/0;
        itEmployeeService.insert(employee);
        JSONResult jsonResult=new JSONResult(true,"添加员工信息成功");

    return jsonResult;
    }

}
