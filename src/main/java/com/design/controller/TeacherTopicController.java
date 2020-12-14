package com.design.controller;

import com.design.entity.*;
import com.design.entity.TopicCustom.TopicCustom;
import com.design.pojo.MyResult;
import com.design.service.CourseTypeService;
import com.design.service.SemesterTypeService;
import com.design.service.TopicService;
//import com.iustu.common.util.UploadUtil;
//import com.iustu.entity.Blog;
//import com.iustu.entity.custom.BlogCustom;
//import com.iustu.service.BlogService;
//import com.iustu.service.BlogTypeService;
//import com.iustu.service.CommentService;
import com.design.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher/topic", method = RequestMethod.POST)
public class TeacherTopicController {

    @Value("${UPLOAD_PATH}")
    private String UPLOAD_PATH;

    @Autowired
    private TopicService topicService;
//    @Autowired
//    private BlogTypeService blogTypeService;
//    @Autowired
//    private CommentService commentService;
    @Autowired
    private CourseTypeService courseTypeService;
    @Autowired
    private SemesterTypeService semesterTypeService;
    @Autowired
    private UserService userService;

//    @RequestMapping("/list")
//    @ResponseBody
//    public <list> MyResult getBlogList(@RequestParam(value="title", required=false) String title) {
//        MyResult result = new MyResult();
//        //请求参数中page从1开始
//        List<CourseType> list;
//        List<SemesterType> list1;
//        List<User> list2;
//        list = courseTypeService.getCourseTypeList();
//        list1 = semesterTypeService.getSemesterTypeList();
//        list2 = userService.getUserList();
////        if(title == null || title.equals("")){
////            list = blogService.getBlogListByPage(rows * (page - 1), rows);
////        }else{
////            list = blogService.getBlogListByTitleAndPage(rows * (page - 1), rows, "%" + title + "%");
////        }
//        List<TopicCustom> resultList = new ArrayList<>();
//        for(CourseType courseType : list){
//            TopicCustom topicCustom = new TopicCustom();
////            将
//            BeanUtils.copyProperties(courseType, topicCustom);
//
//            Integer TopicCourseId = topicCustom.getTopicCourseId();
//            String CourseName = courseTypeService.getCourseTypeNameById(TopicCourseId);
//            topicCustom.setCourseName(CourseName);
//            resultList.add(topicCustom);
//        }
//        for (SemesterType semesterType : list1) {
//            TopicCustom topicCustom = new TopicCustom();
////            将
//            BeanUtils.copyProperties(semesterType, topicCustom);
//
//            Integer TopicSemesterId = topicCustom.getTopicSemesterId();
//            String SemesterName = semesterTypeService.getSemesterTypeNameById(TopicSemesterId);
//            topicCustom.setSemesterName(SemesterName);
//            resultList.add(topicCustom);
//        }
//
//        for (User user : list2) {
//            TopicCustom topicCustom = new TopicCustom();
////            将
//            BeanUtils.copyProperties(user, topicCustom);
//
//            Integer TopicTeacherId = topicCustom.getTeacherId();
//            User user1 = userService.getUserById(TopicTeacherId);
//            String TeacherName = user1.getUsername();
//            topicCustom.setTeacherName(TeacherName);
//            resultList.add(topicCustom);
//        }
//        result.setRows(resultList);
//
//        result.setTotal(topicService.getTopicCount());
//
//        return result;
//    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertTopic(Topic topic){
//        从登录的session中得到老师的信息来确定选题所属的院系
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Integer teacher_id= user.getId();
//        老师发布题目时一般认为题目为被任何人选取
        String  topic_status = "unchosen";
//        将topic还没有的内容填满
        topic.setTeacherId(teacher_id);
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

//    @RequestMapping("/update")
//    @ResponseBody
//    public String modifyBlog(Blog blog, @RequestParam(value = "imageFile", required = false) MultipartFile imageFile, HttpServletRequest request){
//        //不能改变如create_time的属性
//        Blog blog1 = blogService.getBlogById(blog.getId());
//        blog1.setTitle(blog.getTitle());
//        blog1.setContent(blog.getContent());
//        blog1.setTypeId(blog.getTypeId());
//        blog1.setSummary(blog.getSummary());
//        blog1.setUpdateDate(new Date());
//        if (imageFile != null && !imageFile.isEmpty()) {
//            String imageName = null;
//            try {
//                imageName = UploadUtil.uploadFile(UPLOAD_PATH, imageFile, request);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            blog1.setBlogImage(imageName);
//        }
//        if(!(blog.getReprint() == null || blog.getReprint().equals(""))){
//            blog1.setReprint(blog.getReprint());
//        }
//        blogService.updateBlog(blog1);
//        return "success";
//    }
//
//    @RequestMapping("/delete/{ids}")
//    @ResponseBody
//    public String deleteBlogById(@PathVariable String ids){
//        String[] strings = ids.split(",");
//        for(String str : strings){
//            int id = Integer.parseInt(str);
//            commentService.deleteCommentByBlogId(id);
//            blogService.deleteBlogById(id);
//        }
//        return "success";
//    }
//
//    @RequestMapping("/get/{blogId}")
//    @ResponseBody
//    public BlogCustom getBlogById(@PathVariable Integer blogId){
//        BlogCustom blogCustom = new BlogCustom();
//        Blog blog = blogService.getBlogById(blogId);
//        BeanUtils.copyProperties(blog, blogCustom);
//        blogCustom.setBlogType(blogTypeService.getBlogTypeNameById(blogCustom.getTypeId()));
//        return blogCustom;
//    }
//@RequestMapping("/topic/{topicId}")
//public String showModifyBlog(@PathVariable Integer topicId, Model model) {
//    model.addAttribute("blogTypeList", blogTypeService.getBlogTypeList());
//    model.addAttribute("blog", blogService.getBlogById(blogId));
//    return "admin/show";
//}

}
