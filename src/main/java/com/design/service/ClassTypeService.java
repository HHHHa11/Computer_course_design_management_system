package com.design.service;

import com.design.entity.ClassType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClassTypeService {

    String getClassTypeNameById(Integer id);
    List<ClassType> getClassTypeList();
//    List<ClassType> getClassTypeListByPage(int start, int rows);
    int getClassTypeCount();
    void insertClassType(ClassType classType);
    void updateClassType(ClassType classType);
    void deleteClassType(int id);
    public String readExcelFile(MultipartFile file);

}
