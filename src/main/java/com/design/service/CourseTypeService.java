package com.design.service;

import com.design.entity.CourseType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseTypeService {

    String getCourseTypeNameById(Integer id);
    List<CourseType> getCourseTypeList();
//    List<CourseType> getCourseTypeListByPage(int start, int rows);
    int getCourseTypeCount();
    void insertCourseType(CourseType courseType);
    void updateCourseType(CourseType courseType);
    void deleteCourseType(int id);
    public String readExcelFile(MultipartFile file);

}
