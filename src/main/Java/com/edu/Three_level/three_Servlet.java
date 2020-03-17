package com.edu.Three_level;


import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/three_Servlet")
public class three_Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String level = req.getParameter("level");
        String parent = req.getParameter("parent");
        List list = new ArrayList();
        if(level.equals("one")){
            list.add(new three("001","C++"));
            list.add(new three("002","Java"));
            list.add(new three("003","高等数学"));
        }
        else if(level.equals("two")){
            if(parent.equals("001")){
                list.add(new three("0010","C++进阶"));
                list.add(new three("0011","C++算法"));
            }
            else if(parent.equals("002")){
                list.add(new three("0020","Web"));
                list.add(new three("0021","JAVA_Bean"));
            }
            else  if(parent.equals("003")){
                list.add(new three("0030","离散数学"));
                list.add(new three("0031","概率论"));
            }
        }
        else if(level.equals("three")){
            if(parent.equals("0010")){
                list.add(new three("00101","入门"));
                list.add(new three("00102","进阶"));
            }
            else if(parent.equals("0011")){
                list.add(new three("00111","算法入门"));
                list.add(new three("00112","算法进阶"));
            }
            else if(parent.equals("0020")){
                list.add(new three("00201","Web入门"));
                list.add(new three("00202","Web进阶"));
            }
            else if(parent.equals("0021")){
                list.add(new three("00211","JAVA_Bean入门"));
                list.add(new three("00212","JAVA_Bean进阶"));
            }
            else if(parent.equals("0030")){
                list.add(new three("00301","离散数学入门"));
                list.add(new three("00302","离散数学进阶"));
            }
            else if(parent.equals("0031")){
                list.add(new three("00311","概率论入门"));
                list.add(new three("00312","概率论进阶"));
            }
        }
        String json = JSON.toJSONString(list);
        resp.getWriter().println(json);
    }
}
