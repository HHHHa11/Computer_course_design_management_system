package com.design.controller;

import com.design.entity.ClassType;
import com.design.pojo.MyResult;
import com.design.service.ClassTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/classType", method = RequestMethod.POST)
public class ClassManageController {

    @Autowired
    private ClassTypeService classTypeService;
//    @Autowired
//    private BlogService blogService;

    @RequestMapping("/list")
    @ResponseBody
    public MyResult getClassTypeListByPage(){
        MyResult result = new MyResult();
        List<ClassType> list = classTypeService.getClassTypeList();
//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getClass());
        result.setRows(list);
        System.out.println("111111111111111111111111111111111111111111");
        System.out.println(list.get(1).getClassName());
        result.setTotal(classTypeService.getClassTypeCount());
        return result;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public String insertClassType(ClassType classType){
        System.out.println("----------------------------------------------------------");
        System.out.println(classType.getClassName());
        classTypeService.insertClassType(classType);
        System.out.println("insert:" + new Date().toString() + "  " + classType.getId());
        return "success";
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String updateClassType(@PathVariable int id, ClassType classType){
        classType.setId(id);
        classTypeService.updateClassType(classType);
        System.out.println("update:" + new Date().toString() + "  " + classType.getId());
        return "success";
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public String deleteClassType(@PathVariable String ids){
        String[] strings = ids.split(",");
        for(String str : strings){
            int id = Integer.parseInt(str);
            //删除关联的blog
//            blogService.deleteBlogByTypeId(id);
            classTypeService.deleteClassType(id);
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
            readResult = classTypeService.readExcelFile(file);
            System.out.println("canshu :" + readResult);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("upload falure");
        }
        System.out.println("插入结果=" + readResult);
        mv.addObject("readResult", readResult);
        mv.setViewName("admin/classmanage");
        return mv;
    }

}
