package com.edu.Ajax;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Channel_Servlet")
public class Channel_Servlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String level = req.getParameter("level");
        String parent = req.getParameter("parent");
        List list = new ArrayList();
        if(level.equals("1")){
            list.add(new Channel("AI","前沿/区块链/人工智能"));
            list.add(new Channel("Web","前段/小程序/Js"));
        }
        else if(level.equals("2")){
            if(parent.equals("AI")){
                list.add(new Channel("Micro","微服务"));
                list.add(new Channel("Blockchain","区块链"));
                list.add(new Channel("Other","..."));
            }
            else if(parent.equals("Web")){
                list.add(new Channel("Html","Html"));
                list.add(new Channel("Css","Css"));
                list.add(new Channel("Other","..."));
            }
        }
        String json = JSON.toJSONString(list);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }
}
