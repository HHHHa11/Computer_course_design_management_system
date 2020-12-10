package com.design.service.Impl;

import com.design.Util.ReadExcelUtilforCourseType;
import com.design.dao.CourseTypeMapper;
import com.design.entity.CourseType;
import com.design.entity.CourseTypeExample;
import com.design.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;
//    @Autowired
//    private BlogTypeMapperCustom blogTypeMapperCustom;

    @Override
    public String getCourseTypeNameById(Integer id) {
        CourseType courseType = courseTypeMapper.selectByPrimaryKey(id);
        String result = courseType.getCourseName();
        return result;
    }

    @Override
    public List<CourseType> getCourseTypeList() {
        CourseTypeExample example = new CourseTypeExample();
        return courseTypeMapper.selectByExample(example);
    }

//    @Override
//    public List<CourseType> getBlogTypeListByPage(int start, int rows) {
//        return blogTypeMapperCustom.getBlogTypeListByPage(start, rows);
//    }

    public int getCourseTypeCount() {
        CourseTypeExample example = new CourseTypeExample();
        return courseTypeMapper.countByExample(example);
    }

    @Override
    public void insertCourseType(CourseType courseType) {
        courseTypeMapper.insert(courseType);
    }

    @Override
    public void updateCourseType(CourseType courseType) {
        courseTypeMapper.updateByPrimaryKey(courseType);
    }

    @Override
    public void deleteCourseType(int id) {
        courseTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String readExcelFile(MultipartFile file) {
        //创建处理EXCEL的类
        ReadExcelUtilforCourseType readExcelforCourseType = new ReadExcelUtilforCourseType();
        //解析excel，获取上传的事件单
        List<CourseType> semList = null;
        int insertResult = 0;
        String insertMsg = "";
        try {
            semList = readExcelforCourseType.getExcelInfo(file);
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            //和你具体业务有关,这里不做具体的示范
            //数据库插入
            for (CourseType s : semList) {
                insertResult += courseTypeMapper.insertSelective(s);
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
        for (CourseType s : semList) {
            System.out.println("打印excel中的数据" + s.toString());
        }
        return insertMsg;
    }

}
