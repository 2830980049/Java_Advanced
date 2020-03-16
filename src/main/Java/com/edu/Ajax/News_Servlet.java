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

@WebServlet("/News_Servlet")
public class News_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("t");
        List list = new ArrayList();
        if(type != null && type.equals("pypl")){
            list.add(new News("PYPL-小狗","2020-2-1","PYPL","..."));
            list.add(new News("PYPL-小狗","2020-2-1","PYPL","..."));
            list.add(new News("PYPL-小狗","2020-2-1","PYPL","..."));
            list.add(new News("PYPL-小狗","2020-2-1","PYPL","..."));
        }
        else if(type == null || type.equals("UZI")){
            list.add(new News("UZI-小狗","2020-2-1","ASD","..."));
            list.add(new News("UZI-小狗","2020-2-1","ASD","..."));
            list.add(new News("UZI-小狗","2020-2-1","ASD","..."));
            list.add(new News("UZI-小狗","2020-2-1","ASD","..."));
        }

        String json = JSON.toJSONString(list);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(json);
    }
}
