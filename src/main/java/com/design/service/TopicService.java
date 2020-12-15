package com.design.service;

import com.design.entity.Topic;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TopicService {

//    String getTopicNameById(Integer id);
    List<Topic> getTopicList();
//    List<Topic> getTopicListByPage(int start, int rows);
    int getTopicCount();
    void insertTopic(Topic topic);
    void updateTopic(Topic topic);
    void deleteTopic(int id);
//    public String readExcelFile(MultipartFile file);
    Topic getTopicById(Integer id);

}
