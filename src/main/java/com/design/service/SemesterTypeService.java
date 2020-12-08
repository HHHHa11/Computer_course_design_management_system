package com.design.service;

import com.design.entity.SemesterType;

import java.util.List;

public interface SemesterTypeService {

    String getSemesterTypeNameById(Integer id);
    List<SemesterType> getSemesterTypeList();
//    List<SemesterType> getSemesterTypeListByPage(int start, int rows);
    int getSemesterTypeCount();
    void insertSemesterType(SemesterType semesterType);
    void updateSemesterType(SemesterType semesterType);
    void deleteSemesterType(int id);

}
