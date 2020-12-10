package com.design.controller;

import com.design.Util.CryptographyUtil;
import com.design.entity.User;
import com.design.pojo.MyResult;
import com.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/user", method = RequestMethod.POST)
public class UserManageController {
    private final String SALT = "blog";
    @Autowired
    private UserService userService;
//    @Autowired
//    private BlogService blogService;

    @RequestMapping("/list")
    @ResponseBody
    public MyResult getUserListByPage(){
        MyResult result = new MyResult();
        List<User> list = userService.getUserList();
//        String password = list.get(7).getPassword();
//        String submitPassword = CryptographyUtil.md5(password, SALT);
//        list.get(7).setPassword(submitPassword);

//        System.out.println(list);
//        System.out.println(list.get(7).getPassword());
//        System.out.println(list.get(1).getSemester());
        result.setRows(list);
        result.setTotal(userService.getUserCount());
        return result;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public String insertUser(User user){
        System.out.println("-----------------------------------");
//        提交前需要先进行MD5加密
        String password = user.getPassword();
        String submitPassword = CryptographyUtil.md5(password, SALT);
        user.setPassword(submitPassword);
//        System.out.println(user.getSemester());
        userService.insertUser(user);
        System.out.println("insert:" + new Date().toString() + "  " + user.getId());
        return "success";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateUser(@PathVariable int id, User user){
        user.setId(id);
        //        提交前需要先进行MD5加密
        String password = user.getPassword();
        String submitPassword = CryptographyUtil.md5(password, SALT);
        user.setPassword(submitPassword);

        userService.updateUser(user);
        System.out.println("update:" + new Date().toString() + "  " + user.getId());
        return "success";
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public String deleteUser(@PathVariable String ids){
        String[] strings = ids.split(",");
        for(String str : strings){
            int id = Integer.parseInt(str);
            //删除关联的blog
//            blogService.deleteBlogByTypeId(id);
            userService.deleteUser(id);
        }
        return "success";
    }

    //添加学生的方法  excel 相关的操作   能够将数据插入到数据库

//    //@ResponseBody
//    @RequestMapping(value = "/DoExcel", method = {RequestMethod.POST})
//    public ModelAndView DoExcel(@RequestParam(value = "file_excel") MultipartFile file, HttpServletRequest request) {
//        ModelAndView mv = new ModelAndView();
//        String readResult = null;
//        try {
//            readResult = userService.readExcelFile(file);
//            System.out.println("canshu :" + readResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("upload falure");
//        }
//        System.out.println("插入结果=" + readResult);
//        mv.addObject("readResult", readResult);
//        mv.setViewName("admin/semestermanage");
//        return mv;
//    }



}
