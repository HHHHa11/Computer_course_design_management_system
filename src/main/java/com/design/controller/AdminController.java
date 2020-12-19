package com.design.controller;

import com.design.entity.Topic;
import com.design.pojo.MyResult;
import com.design.service.CourseTypeService;
import com.design.service.SemesterTypeService;
import com.design.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/topic", method = RequestMethod.POST)
public class AdminController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private SemesterTypeService semesterTypeService;

    @RequestMapping("/list")
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

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public String deleteTopic(@PathVariable String ids) {
        String[] strings = ids.split(",");
        for (String str : strings) {
            int id = Integer.parseInt(str);
            //删除关联的blog
//            blogService.deleteBlogByTypeId(id);
            topicService.deleteTopic(id);
        }
        return "success";
    }

    @RequestMapping(value = "/modifyTopic/{id}", method = RequestMethod.GET)
    public String showModifyBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("courseTypeList", courseTypeService.getCourseTypeList());
        model.addAttribute("semesterTypeList", semesterTypeService.getSemesterTypeList());
        model.addAttribute("topic", topicService.getTopicById(id));
        model.addAttribute("topicId", id);
        return "admin/modifyBlog";
    }
    @RequestMapping("/UnAuditList")
    @ResponseBody
    public MyResult getUnAuditList(){
        MyResult result = new MyResult();
        List<Topic> list = topicService.getUnAuditList();
//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getClass());
        result.setRows(list);
//        System.out.println("111111111111111111111111111111111111111111");
//        System.out.println(list.get(1).getClassName());
        result.setTotal(topicService.getTopicCount());
        return result;

    }

    @RequestMapping("/audit/{idss}/{state}")
    @ResponseBody
    public String setCommentState(@PathVariable String idss, @PathVariable String state) {
        String[] strings = idss.split(",");
        for (String str : strings) {
            int id = Integer.parseInt(str);
            Topic topic = topicService.getTopicById(id);
            topic.setTopicAuditStatus(state);
            topicService.updateTopic(topic);
//            Blog blog = blogService.getBlogById(comment.getBlogId());
//            blog.setReplyCount(commentService.getPassedCommentCountByBlogId(blog.getId()));
//            blogService.updateBlog(blog);
        }
        return "success";
    }

    @RequestMapping("/audit1/{idss1}/{state}")
    @ResponseBody
    public String setCommentState1(@PathVariable Integer idss1, @PathVariable String state) {
        System.out.println(idss1);
        System.out.println(state);
        Topic topic = topicService.getTopicById(idss1);
        topic.setTopicAuditStatus(state);
        topicService.updateTopic(topic);
        return "success";
    }
}
