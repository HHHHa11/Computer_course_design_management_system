package com.design.controller;

import com.design.service.HelpThreeDoExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    //添加学生的方法  excel 相关的操作   能够将数据插入到数据库
    @Autowired
    private HelpThreeDoExcelService helpThreeDoExcelService;

    //@ResponseBody
    @RequestMapping(value = "/DoExcel", method = {RequestMethod.POST})
    public ModelAndView DoExcel(@RequestParam(value = "file_excel") MultipartFile file, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String readResult = null;
        try {
            readResult = helpThreeDoExcelService.readExcelFile(file);
            System.out.println("canshu :" + readResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("upload falure");
        }
        System.out.println("插入结果=" + readResult);
        mv.addObject("readResult", readResult);
        mv.setViewName("admin/admin");
        return mv;
    }
}
