package com.design.service.Impl;

import com.design.Util.ReadExcelUtilforSemesterType;
import com.design.dao.TopicMapper;
import com.design.entity.Topic;
import com.design.entity.TopicExample;
import com.design.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;
//    @Autowired
//    private BlogTypeMapperCustom blogTypeMapperCustom;

//    @Override
//    public String getTopicNameById(Integer id) {
//        Topic topic = topicMapper.selectByPrimaryKey(id);
//        String result = topic.getTopicTitle();
//        return result;
//    }

    @Override
    public List<Topic> getTopicList() {
        TopicExample example = new TopicExample();
        return topicMapper.selectByExample(example);
    }

//    @Override
//    public List<Topic> getBlogTypeListByPage(int start, int rows) {
//        return blogTypeMapperCustom.getBlogTypeListByPage(start, rows);
//    }

    public int getTopicCount() {
        TopicExample example = new TopicExample();
        return topicMapper.countByExample(example);
    }

    @Override
    public void insertTopic(Topic topic) {
        topicMapper.insert(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        topicMapper.updateByPrimaryKey(topic);
    }

    @Override
    public void deleteTopic(int id) {
        topicMapper.deleteByPrimaryKey(id);
    }



//    @Override
//    public String readExcelFile(MultipartFile file) {
//        //创建处理EXCEL的类
//        ReadExcelUtilforSemesterType readExcelforSemesterType = new ReadExcelUtilforSemesterType();
//        //解析excel，获取上传的事件单
//        List<SemesterType> semList = null;
//        int insertResult = 0;
//        String insertMsg = "";
//        try {
//            semList = readExcelforSemesterType.getExcelInfo(file);
//            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
//            //和你具体业务有关,这里不做具体的示范
//            //数据库插入
//            for (SemesterType s : semList) {
//                insertResult += semesterTypeMapper.insertSelective(s);
//                System.out.println(s.toString());
//            }
//            if (insertResult == 0) {
//                insertMsg = "All insert false";
//            } else if (insertResult == semList.size()) {
//                insertMsg = "All insert success";
//            } else {
//                insertMsg = "Part insert success";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("接受excel表格中的数据失败！！！");
//        }
//        for (SemesterType s : semList) {
//            System.out.println("打印excel中的数据" + s.toString());
//        }
//        return insertMsg;
//    }
//    @Override
    public Topic getTopicById(Integer id){
        return topicMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Topic> getTopicListByname(String name) {
        return topicMapper.getTopListByname(name);
    }

}
