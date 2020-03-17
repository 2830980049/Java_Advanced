package com.edu.Regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) throws IOException {

        //存放文件内容
        StringBuilder content = new StringBuilder();

        //获取路径 文件输入流
        FileInputStream file = new FileInputStream("E:/IDEA Files/Advanced/src/main/webapp/Regex/regex1.jsp");

        //转化 二进制转可读字符串流
        InputStreamReader reader = new InputStreamReader(file,"utf-8");

        //引入缓冲 提高原始文件的读取效率
        BufferedReader bufferedReader = new BufferedReader(reader);
        String text = "";

        while ((text = bufferedReader.readLine()) != null){
            content.append(text+"\n");
        }
        bufferedReader.close();

        //正则表达式类
        Pattern pattern = Pattern.compile("<li>([\\u4e00-\\u9fa5]{2,10})([a-zA-Z]+)</li>");
        //匹配正则表达式
        Matcher m = pattern.matcher(content);
        //查找匹配结果
        while (m.find()){
            //0 代表完整提取
            //System.out.println(m.group(0));
            String chs = m.group(1);
            String eng = m.group(2);
            System.out.println(chs+"-"+eng);
        }
    }
}
