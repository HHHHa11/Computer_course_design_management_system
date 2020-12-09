package com.design.service.Impl;

import java.util.List;

import com.design.Util.ReadExcelUtil;
import com.design.dao.SemesterTypeMapper;
import com.design.entity.SemesterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.design.service.HelpThreeDoExcelService;

@Service("helpThreeDoExcelService")
public class HelpThreeDoExcelServiceImpl implements HelpThreeDoExcelService {
    @Autowired
    private SemesterTypeMapper semesterTypeMapper;

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