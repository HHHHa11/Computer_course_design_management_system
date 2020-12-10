package com.design.controller;

import com.design.entity.CourseType;
import com.design.pojo.MyResult;
import com.design.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/courseType", method = RequestMethod.POST)
public class CourseManageController {

    @Autowired
    private CourseTypeService courseTypeService;
//    @Autowired
//    private BlogService blogService;

    @RequestMapping("/list")
    @ResponseBody
    public MyResult getCourseTypeListByPage(){
        MyResult result = new MyResult();
        List<CourseType> list = courseTypeService.getCourseTypeList();
//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getCourse());
        result.setRows(list);
        result.setTotal(courseTypeService.getCourseTypeCount());
        return result;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public String insertCourseType(CourseType courseType){
        courseTypeService.insertCourseType(courseType);
        System.out.println("insert:" + new Date().toString() + "  " + courseType.getId());
        return "success";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateCourseType(@PathVariable int id, CourseType courseType){
        courseType.setId(id);
        courseTypeService.updateCourseType(courseType);
        System.out.println("update:" + new Date().toString() + "  " + courseType.getId());
        return "success";
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public String deleteCourseType(@PathVariable String ids){
        String[] strings = ids.split(",");
        for(String str : strings){
            int id = Integer.parseInt(str);
            //删除关联的blog
//            blogService.deleteBlogByTypeId(id);
            courseTypeService.deleteCourseType(id);
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
            readResult = courseTypeService.readExcelFile(file);
            System.out.println("canshu :" + readResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("upload falure");
        }
        System.out.println("插入结果=" + readResult);
        mv.addObject("readResult", readResult);
        mv.setViewName("admin/coursemanage");
        return mv;
    }
}
