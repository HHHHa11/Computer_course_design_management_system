package com.design.controller;

import com.design.entity.Topic;
import com.design.entity.User;
import com.design.service.TopicService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/student/topic",method= RequestMethod.POST)
public class StudentController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/chosen/{topicid}")
    @ResponseBody
    public String chosen(@PathVariable Integer topicid){
        Topic topic = topicService.getTopicById(topicid);
        String topic_status = topic.getTopicStatus();
//        判断该选题是否被选
        String topic_status_character = "chosen";
        if (topic_status.equals(topic_status_character)){
            System.out.println("------------------------------------------------");

            return "false";
        }
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String StudentName = user.getName();
        topic.setTopicStatus(topic_status_character);
        topic.setTopicChosenStudent(StudentName);
        topicService.updateTopic(topic);
        System.out.println(topic.getTopicStatus());
        return "success";
    }


}
