package cn.mycode.ssm.controller;

import cn.mycode.ssm.domain.JSONResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class SSMExceptionHandler {

    //捕获运行过程中出现的异常
    //这个方法在控制层出现异常后，springmvc自动调用
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, HandlerMethod method, HttpServletResponse response){

        String page=null;

        try {
            ex.printStackTrace();
            System.out.println(method.getMethod().getName());

            if(method.hasMethodAnnotation(ResponseBody.class)){
                JSONResult jsonResult=new JSONResult(false,"出现异常辣！");
                response.setContentType("application/json;charset=utf-8");
                ObjectMapper mapper=new ObjectMapper();
                String jsonStr=mapper.writeValueAsString(jsonResult);
                response.getWriter().println(jsonStr);

            }else{
                page="error";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }
}
