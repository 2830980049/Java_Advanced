package com.edu.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FastJson {
    public static void main(String[] args) {
        employ emploies = new employ();
        emploies.setEmpno(6666);
        emploies.setEname("苏苏");
        emploies.setJob("经理");
        emploies.setSalary(10000f);
        emploies.setDname("美术部");
        Calendar c = Calendar.getInstance();
        c.set(2020,0,30,0,0,0);
        emploies.setHdate(c.getTime());

        //FastJson提供了JSON对象
        String json = JSON.toJSONString(emploies);
        System.out.println(json);

        //反序列化转化为JAVA对象
        employ emp = JSON.parseObject(json,employ.class);
        System.out.println(emp.getEname());


        List list = new ArrayList();
        for(int i = 1; i <= 100; i++){
            employ employs = new employ();
            employs.setEmpno(123+i);
            employs.setEname("员工" + i);
            list.add(employs);
        }
        String jsons = JSON.toJSONString(list);
        System.out.println(jsons);

        List<employ> emps = JSON.parseArray(jsons,employ.class);
        for(employ e : emps)
            System.out.println(e.getEmpno()+" "+e.getEname());
    }
}
