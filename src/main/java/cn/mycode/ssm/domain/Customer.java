package cn.mycode.ssm.domain;

import com.alibaba.excel.annotation.ExcelIgnore;

import java.util.Date;

public class Customer {
    @ExcelIgnore
    private Long id;
    @ExcelIgnore
    private String name;
    @ExcelIgnore
    private Integer age;
    @ExcelIgnore
    private Integer gender;//0为男 1为女
    @ExcelIgnore
    private String tel;
    @ExcelIgnore
    private String qq;
    @ExcelIgnore
    private String job;
    @ExcelIgnore
    private String source;//收入来源

    //以下都不需要录入
    private Employee seller;//负责人
    private Employee inputUser;//创建人
    private Date inputTime;//当前系统时间

    private Status status;//状态信息，不可见
    private Date positiveTime;//转正时间，不可见

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public Employee getInputUser() {
        return inputUser;
    }

    public void setInputUser(Employee inputUser) {
        this.inputUser = inputUser;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getPositiveTime() {
        return positiveTime;
    }

    public void setPositiveTime(Date positiveTime) {
        this.positiveTime = positiveTime;
    }
}
