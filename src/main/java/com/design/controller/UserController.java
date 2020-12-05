package com.design.controller;

import com.Test.Test;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
//      通过源码可知shiro是通过置空session来达到退出用户的功能
//        Test test = new Test();
        SecurityUtils.getSubject().logout();
//        test.SessionTest(request,session);
        return "redirect:/index";
    }
}
