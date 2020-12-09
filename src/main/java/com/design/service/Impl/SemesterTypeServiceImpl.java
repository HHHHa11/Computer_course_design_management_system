package com.design.service.Impl;

import com.design.Util.ReadExcelUtil;
import com.design.entity.SemesterType;
import com.design.entity.SemesterTypeExample;
import com.design.dao.SemesterTypeMapper;
import com.design.service.SemesterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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



    @Override
    public String readExcelFile(MultipartFile file) {
        //创建处理EXCEL的类
        ReadExcelUtil readExcel = new ReadExcelUtil();
        //解析excel，获取上传的事件单
        List<SemesterType> semList = null;
        int insertResult = 0;
        String insertMsg = "";
        try {
            semList = readExcel.getExcelInfo(file);
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            //和你具体业务有关,这里不做具体的示范
            //数据库插入
            for (SemesterType s : semList) {
                insertResult += semesterTypeMapper.insertSelective(s);
                System.out.println(s.toString());
            }
            if (insertResult == 0) {
                insertMsg = "All insert false";
            } else if (insertResult == semList.size()) {
                insertMsg = "All insert success";
            } else {
                insertMsg = "Part insert success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("接受excel表格中的数据失败！！！");
        }
        for (SemesterType s : semList) {
            System.out.println("打印excel中的数据" + s.toString());
        }
        return insertMsg;
    }

}
