package com.design.controller;

import com.design.entity.Topic;
import com.design.pojo.MyResult;
import com.design.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SourceController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topic/list")
    @ResponseBody
    public MyResult getTopicListByPage() {
        MyResult result = new MyResult();
        List<Topic> list = topicService.getTopicList();
//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getClass());
        result.setRows(list);
//        System.out.println("111111111111111111111111111111111111111111");
//        System.out.println(list.get(1).getClassName());
        result.setTotal(topicService.getTopicCount());
        return result;
    }
}
