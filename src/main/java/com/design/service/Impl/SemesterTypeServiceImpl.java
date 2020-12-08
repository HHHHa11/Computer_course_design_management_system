package com.design.service.Impl;

import com.design.entity.SemesterType;
import com.design.entity.SemesterTypeExample;
import com.design.dao.SemesterTypeMapper;
import com.design.service.SemesterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterTypeServiceImpl implements SemesterTypeService {

    @Autowired
    private SemesterTypeMapper semesterTypeMapper;
//    @Autowired
//    private BlogTypeMapperCustom blogTypeMapperCustom;

    @Override
    public String getSemesterTypeNameById(Integer id) {
        SemesterType semesterType = semesterTypeMapper.selectByPrimaryKey(id);
        String result = semesterType.getSemester();
        return result;
    }

    @Override
    public List<SemesterType> getSemesterTypeList() {
        SemesterTypeExample example = new SemesterTypeExample();
        return semesterTypeMapper.selectByExample(example);
    }

//    @Override
//    public List<SemesterType> getBlogTypeListByPage(int start, int rows) {
//        return blogTypeMapperCustom.getBlogTypeListByPage(start, rows);
//    }

    public int getSemesterTypeCount() {
        SemesterTypeExample example = new SemesterTypeExample();
        return semesterTypeMapper.countByExample(example);
    }

    @Override
    public void insertSemesterType(SemesterType semesterType) {
        semesterTypeMapper.insert(semesterType);
    }

    @Override
    public void updateSemesterType(SemesterType semesterType) {
        semesterTypeMapper.updateByPrimaryKey(semesterType);
    }

    @Override
    public void deleteSemesterType(int id) {
        semesterTypeMapper.deleteByPrimaryKey(id);
    }

}
