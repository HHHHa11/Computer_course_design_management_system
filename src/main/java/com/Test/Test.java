package com.Test;

import com.design.entity.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class Test {
//    查看各个session的内容
    public void SessionTest(HttpServletRequest request, HttpSession session) {

        HttpSession session1 = request.getSession();

        Enumeration enumeration = session.getAttributeNames();

        while (enumeration.hasMoreElements()) {

            String name1 = enumeration.nextElement().toString();

            Object value = request.getSession().getAttribute(name1);

            System.out.println(name1 + ":" + value.toString());

//
        }
    }
//    获取每一个user的数据
    public void UserData(User user){
        System.out.println("id" + ":" +user.getId());
        System.out.println("name" + ":" + user.getName());
//        System.out.println("student_number" + ":" + user.getStudentNumber());
        System.out.println("classes" + ":" + user.getClasses());
//        System.out.println("gender" + ":" + user.getGender());
//        System.out.println("email" + ":" + user.getEmail());
        System.out.println("username" + ":" + user.getUsername());
        System.out.println("password" + ":" + user.getPassword());
        System.out.println("identity" + ":" + user.getIdentity());

    }
}
