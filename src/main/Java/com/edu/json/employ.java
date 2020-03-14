package com.edu.json;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class employ {
    private  Integer empno;
    private String ename;
    private String job;
    //注解
    @JSONField(name = "hdate", format = "yyyy-MM-dd HH:mm:ss SSS")
    private Date hdate;

    private Float salary;

    @JSONField(serialize = false)
    private String dname;

    public employ(){

    }

    public employ(Integer empno, String ename, String job, Date hdate, Float salary, String dname) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hdate = hdate;
        this.salary = salary;
        this.dname = dname;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
