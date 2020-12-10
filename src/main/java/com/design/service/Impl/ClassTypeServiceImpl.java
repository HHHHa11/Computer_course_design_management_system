package com.design.service.Impl;


import com.design.Util.ReadExcelUtilforClassType;
import com.design.dao.ClassTypeMapper;
import com.design.entity.ClassType;
import com.design.entity.ClassTypeExample;
import com.design.service.ClassTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {

    @Autowired
    private ClassTypeMapper classTypeMapper;
//    @Autowired
//    private BlogTypeMapperCustom blogTypeMapperCustom;

    @Override
    public String getClassTypeNameById(Integer id) {
        ClassType classType = classTypeMapper.selectByPrimaryKey(id);
        String result = classType.getClassName();
        return result;
    }

    @Override
    public List<ClassType> getClassTypeList() {
        ClassTypeExample example = new ClassTypeExample();
        return classTypeMapper.selectByExample(example);
    }

//    @Override
//    public List<ClassType> getBlogTypeListByPage(int start, int rows) {
//        return blogTypeMapperCustom.getBlogTypeListByPage(start, rows);
//    }

    public int getClassTypeCount() {
        ClassTypeExample example = new ClassTypeExample();
        return classTypeMapper.countByExample(example);
    }

    @Override
    public void insertClassType(ClassType classType) {
        classTypeMapper.insert(classType);
    }

    @Override
    public void updateClassType(ClassType classType) {
        classTypeMapper.updateByPrimaryKey(classType);
    }

    @Override
    public void deleteClassType(int id) {
        classTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String readExcelFile(MultipartFile file) {
        //创建处理EXCEL的类
        ReadExcelUtilforClassType readExcelforClassType = new ReadExcelUtilforClassType();
        //解析excel，获取上传的事件单
        List<ClassType> semList = null;
        int insertResult = 0;
        String insertMsg = "";
        try {
            semList = readExcelforClassType.getExcelInfo(file);
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            //和你具体业务有关,这里不做具体的示范
            //数据库插入
            for (ClassType s : semList) {
                insertResult += classTypeMapper.insertSelective(s);
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
        for (ClassType s : semList) {
            System.out.println("打印excel中的数据" + s.toString());
        }
        return insertMsg;
    }

}
