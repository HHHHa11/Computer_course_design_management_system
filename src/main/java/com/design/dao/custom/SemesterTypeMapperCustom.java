package com.design.dao.custom;

import com.design.entity.SemesterType;

import java.util.List;

public interface SemesterTypeMapperCustom {
    List<SemesterType> getSemesterTypeListByPage(int start, int rows);
}
