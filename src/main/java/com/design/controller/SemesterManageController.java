package com.design.controller;

import com.design.pojo.MyResult;
import com.design.entity.SemesterType;
import com.design.service.SemesterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
