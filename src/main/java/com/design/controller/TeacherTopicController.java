package com.design.controller;

import com.design.entity.Topic;
import com.design.entity.User;
import com.design.pojo.MyResult;
import com.design.service.CourseTypeService;
import com.design.service.SemesterTypeService;
import com.design.service.TopicService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher/topic", method = RequestMethod.POST)
public class TeacherTopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private SemesterTypeService semesterTypeService;
//    @Autowired
//    private BlogService blogService;




    @RequestMapping("/insert")
    @ResponseBody
    public String insertTopic(Topic topic) {

        System.out.println(topic.getTopicType());
//        从登录的session中得到老师的信息来确定选题所属的院系
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String teacher_Name = user.getName();
//        老师发布题目时一般认为题目为被任何人选取
        String topic_status = "unchosen";
//        将topic还没有的内容填满
        topic.setTeacherName(teacher_Name);
        topic.setTopicStatus(topic_status);

//
//        //补全blog属性
//        blog.setClickCount(0);
//        blog.setLikeCount(0);
//        blog.setReplyCount(0);
//        blog.setCreateDate(new Date());
//        blog.setUpdateDate(new Date());
////        有图片文件则获取相应的路径
//
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String imageName = null;
//            try {
//                imageName = UploadUtil.uploadFile(UPLOAD_PATH, imageFile, request);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            blog.setBlogImage(imageName);
//        }
//
//提交
        topicService.insertTopic(topic);
        return "success";
    }
    @RequestMapping("/update")
    @ResponseBody
    public String updateTopic(Topic topic) {
        System.out.println(topic);
        Topic topic1 = topicService.getTopicById(topic.getId());
        topic1.setTopicTitle(topic.getTopicTitle());
        topic1.setTopicCourse(topic.getTopicCourse());
        topic1.setTopicSemester(topic.getTopicSemester());
        topic1.setTopicType(topic.getTopicType());
        topic1.setTopicSource(topic.getTopicSource());
        topic1.setTopicIntegratedCurriculum(topic.getTopicIntegratedCurriculum());
        topic1.setTopicContent(topic.getTopicContent());
        topic1.setTopicRequirements(topic.getTopicRequirements());
        topic1.setTopicMainDifficulties(topic.getTopicMainDifficulties());
        topicService.updateTopic(topic1);
        System.out.println("update:" + new Date().toString() + "  " + topic.getId());
        return "success";
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

    //添加学生的方法  excel 相关的操作   能够将数据插入到数据库
//
//    //@ResponseBody
//    @RequestMapping(value = "/DoExcel", method = {RequestMethod.POST})
//    public ModelAndView DoExcel(@RequestParam(value = "file_excel") MultipartFile file, HttpServletRequest request) {
//        ModelAndView mv = new ModelAndView();
//        String readResult = null;
//        try {
//            readResult = topicService.readExcelFile(file);
//            System.out.println("canshu :" + readResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("upload falure");
//        }
//        System.out.println("插入结果=" + readResult);
//        mv.addObject("readResult", readResult);
//        mv.setViewName("admin/classmanage");
//        return mv;
//    }

    @RequestMapping(value = "/modifyTopic/{id}",method = RequestMethod.GET)
    public String showModifyBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("courseTypeList", courseTypeService.getCourseTypeList());
        model.addAttribute("semesterTypeList", semesterTypeService.getSemesterTypeList());
        model.addAttribute("topic", topicService.getTopicById(id));
        model.addAttribute("topicId",id);
        return "admin/modifyBlog";
    }

}