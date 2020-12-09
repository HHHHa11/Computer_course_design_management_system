package com.design.controller;

import com.design.pojo.MyResult;
import com.design.entity.SemesterType;
import com.design.service.SemesterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/semesterType", method = RequestMethod.POST)
public class SemesterManageController {

    @Autowired
    private SemesterTypeService semesterTypeService;
//    @Autowired
//    private BlogService blogService;

    @RequestMapping("/list")
    @ResponseBody
    public MyResult getSemesterTypeListByPage(){
        MyResult result = new MyResult();
        List<SemesterType> list = semesterTypeService.getSemesterTypeList();
//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getSemester());
        result.setRows(list);
        result.setTotal(semesterTypeService.getSemesterTypeCount());
        return result;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public String insertSemesterType(SemesterType semesterType){
        semesterTypeService.insertSemesterType(semesterType);
        System.out.println("insert:" + new Date().toString() + "  " + semesterType.getId());
        return "success";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateSemesterType(@PathVariable int id, SemesterType semesterType){
        semesterType.setId(id);
        semesterTypeService.updateSemesterType(semesterType);
        System.out.println("update:" + new Date().toString() + "  " + semesterType.getId());
        return "success";
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public String deleteSemesterType(@PathVariable String ids){
        String[] strings = ids.split(",");
        for(String str : strings){
            int id = Integer.parseInt(str);
            //删除关联的blog
//            blogService.deleteBlogByTypeId(id);
            semesterTypeService.deleteSemesterType(id);
        }
        return "success";
    }

    //添加学生的方法  excel 相关的操作   能够将数据插入到数据库

    //@ResponseBody
    @RequestMapping(value = "/DoExcel", method = {RequestMethod.POST})
    public ModelAndView DoExcel(@RequestParam(value = "file_excel") MultipartFile file, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String readResult = null;
        try {
            readResult = semesterTypeService.readExcelFile(file);
            System.out.println("canshu :" + readResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("upload falure");
        }
        System.out.println("插入结果=" + readResult);
        mv.addObject("readResult", readResult);
        mv.setViewName("admin/semestermanage");
        return mv;
    }



}
