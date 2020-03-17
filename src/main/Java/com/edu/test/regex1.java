package com.edu.test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex1 {
    public static void main(String[] args) throws IOException {
        StringBuilder content = new StringBuilder();
        FileInputStream file = new FileInputStream("E:/IDEA Files/Advanced/src/main/webapp/test/regex1.jsp");
        InputStreamReader reader = new InputStreamReader(file,"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String text = "";
        while (( text = bufferedReader.readLine()) != null)
            content.append(text+"\n");

        bufferedReader.close();
        Pattern pattern = Pattern.compile("<li>([\\u4e00-\\u9fa5]{2,10})([a-zA-Z]+)</li>");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            String ch = matcher.group(1);
            String eng = matcher.group(2);
            System.out.println(ch+"-"+eng);
        }
    }
}
