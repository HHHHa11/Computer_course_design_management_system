package com.design.controller;

import com.design.Util.ExportExcel;
import com.design.entity.Blog;
import com.design.entity.Topic;
import com.design.entity.TopicGuidances;
import com.design.entity.User;
import com.design.pojo.MyResult;
import com.design.service.CourseTypeService;
import com.design.service.SemesterTypeService;
import com.design.service.TopicGuidanceService;
import com.design.service.TopicService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/teacher/topic", method = RequestMethod.POST)
public class TeacherTopicController {
    @Value("${UPLOAD_PATH}")
    private String UPLOAD_PATH;

    @Autowired
    private TopicService topicService;
    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private SemesterTypeService semesterTypeService;

    @Autowired
    private TopicGuidanceService topicGuidanceService;

    //    @Autowired
//    private BlogService blogService;
    @RequestMapping("/list")
    @ResponseBody
    public MyResult getTopicListByPage() {
        MyResult result = new MyResult();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String name = user.getName();
        System.out.println(name);
//        老师只能看属于自己的题目
        List<Topic> list = topicService.getTopicListByname(name);
        //        System.out.println(list);
        //        System.out.println(list.get(0).getId());
        //        System.out.println(list.get(1).getClass());
        result.setRows(list);
        //        System.out.println("111111111111111111111111111111111111111111");
        //        System.out.println(list.get(1).getClassName());
        result.setTotal(topicService.getTopicCount());
        return result;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public String insertTopic(Topic topic) {

        System.out.println(topic.getTopicType());
//        从登录的session中得到老师的信息来确定选题所属的院系
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String teacher_Name = user.getName();
//        老师发布题目时一般认为题目为被任何人选取
        String topic_status = "unchosen";
        String topic_Audit_Status = "unAudit";
        String topic_assignmentbook_name = "null";
        String topic_report_name = "null";
        String topic_topicComment = "null";
//        将topic还没有的内容填满
        topic.setTopicAuditStatus(topic_Audit_Status);
        topic.setTeacherName(teacher_Name);
        topic.setTopicStatus(topic_status);
        topic.setTopicAssignmentbookName(topic_assignmentbook_name);
        topic.setTopicReportName(topic_report_name);
        topic.setTopicComment(topic_topicComment);

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

    @RequestMapping(value = "/modifyTopic/{id}", method = RequestMethod.GET)
    public String showModifyBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("courseTypeList", courseTypeService.getCourseTypeList());
        model.addAttribute("semesterTypeList", semesterTypeService.getSemesterTypeList());
        model.addAttribute("topic", topicService.getTopicById(id));
        model.addAttribute("topicId", id);
        return "admin/modifyBlog";
    }

    @RequestMapping("/assignmentbooklist")
    @ResponseBody
    public MyResult getTopicListByNameAndChosen() {
        MyResult result = new MyResult();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String name = user.getName();
        System.out.println(name);
//        看任务书列表时，老师只能看属于自己且被选择的题目
        List<Topic> list = topicService.getTopicListByNameAndChosen(name);
        //        System.out.println(list);
        //        System.out.println(list.get(0).getId());
        //        System.out.println(list.get(1).getClass());
        result.setRows(list);
        //        System.out.println("111111111111111111111111111111111111111111");
        //        System.out.println(list.get(1).getClassName());
        result.setTotal(topicService.getTopicCount());
        return result;
    }

    @RequestMapping("/AssignmentBook/{id1}")
    @ResponseBody
    public String Upload(@PathVariable Integer id1, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(id1 + "______________________________");
        String path = request.getServletContext().getRealPath(UPLOAD_PATH);
        System.out.println(path);
        if (file == null) {
            return "filenull";
        }
        String fileName = file.getOriginalFilename();
        File dir = new File(path, fileName);
        System.out.println("filename" + fileName);
        System.out.println(dir.exists());
        System.out.println("file_status:" + file.isEmpty());

//判断文件内容是否为空
        if (file.isEmpty() == true) {
            return "fileempty";
        }
//         判断指定文件夹是否存在
        else if (!dir.exists()) {
            System.out.println("111111111111111111111111111111111111111111111");
            dir.mkdirs();
            file.transferTo(dir);
        } else {
            file.transferTo(dir);

        }
        Topic topic = topicService.getTopicById(id1);
        topic.setTopicAssignmentbookAddress(UPLOAD_PATH + "/" + fileName);
        topic.setTopicAssignmentbookName(fileName);
        System.out.println(UPLOAD_PATH + "/" + fileName);
        topicService.updateTopic(topic);

        return "success";

    }


    @RequestMapping(value = "ReportDownload/{id5}", method = RequestMethod.GET)
    @ResponseBody
    public void Upload(@PathVariable Integer id5, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Topic topic = topicService.getTopicById(id5);

        String Totalpath = topic.getTopicReportAddress();

        String path = request.getServletContext().getRealPath(Totalpath);

        File fullURL = new File(path);

//        System.out.println(fullURL.getName());
//
//        System.out.println(path);

        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));


//        String Originfilename = path.substring(path.lastIndexOf("\\") + 1);
        String filename = fullURL.getName();


        filename = URLEncoder.encode(filename, "UTF-8");


        response.addHeader("Content-Disposition", "attachment;filename=" + filename);


        response.setContentType("multipart/form-data");


        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());

        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();

    }

    @RequestMapping(value = "/scoreadd/{id6}")
    @ResponseBody
    public String insertScoreTopic(@PathVariable Integer id6,Topic topic){
        Topic topic1 = topicService.getTopicById(id6);
        System.out.println(topic.getTopicScore()<0);
//        添加时需要判断内容是否为空
//        然后需要判断输入的分数是否在0-100之间
        if (topic1.getTopicScore()!= null){
            return "falseadd";
        }else if (topic.getTopicScore()<0 || topic.getTopicScore()>100){
            return "illegal";
        }
        topic1.setTopicScore(topic.getTopicScore());
        topicService.updateTopic(topic1);
        return "success";






    }

    @RequestMapping(value = "/scoreupdate/{id7}")
    @ResponseBody
    public String updateScoreTopic(@PathVariable Integer id7, Topic topic) {
        Topic topic1 = topicService.getTopicById(id7);
        System.out.println(topic.getTopicScore() < 0);
//        添加时需要判断内容是否为空
//        然后需要判断输入的分数是否在0-100之间

        if (topic.getTopicScore() < 0 || topic.getTopicScore() > 100) {
            return "illegal";
        }
        topic1.setTopicScore(topic.getTopicScore());
        topicService.updateTopic(topic1);
        return "success";


    }

    @RequestMapping("/scoredelete/{id8}")
    @ResponseBody
    public String deleteUser(@PathVariable String id8) {
        String[] strings = id8.split(",");
        for (String str : strings) {
            int id = Integer.parseInt(str);
            //删除关联的blog
//            blogService.deleteBlogByTypeId(id);
            Topic topic1 = topicService.getTopicById(id);
            topic1.setTopicScore(null);
            topicService.updateTopic(topic1);
//            topicService.deleteUser(id);
        }
        return "success";
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    public void export(HttpServletResponse response) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String TeacherName = user.getName();
        System.out.println(TeacherName+"111111111111111");
        List<Topic> topicList = topicService.getTopicForExcel(TeacherName);
        System.out.println("22222");
//        System.out.println(topicList.get(33).getTopicSource() +"--------------------------------------------------------");
        ExportExcel<Topic> ee = new ExportExcel<Topic>();
        String[] headers = {"序号","题目","课程","学生名","成绩"};
        String fileName = "成绩导出表";
        ee.exportExcel(headers,topicList,fileName,response);
    }

    @RequestMapping(value = "/commentinsert/{id9}",method = RequestMethod.GET)
    @ResponseBody
    public String commentInsert(@PathVariable int id9, Topic topic){
        System.out.println(id9);
        System.out.println(topic.getTopicComment());
        System.out.println("11111111111111111");
        if(topic.getTopicComment() == null){
            System.out.println("2222222222222");
            return "false";
        }
        System.out.println("33333333333333333");
        Topic topic1 = topicService.getTopicById(id9);
        System.out.println("444444444444444444");
        topic1.setTopicComment(topic.getTopicComment());
        System.out.println("555555555555555555");
        topicService.updateTopic(topic1);
        System.out.println(topicService.getTopicById(id9).getTopicComment());
        return "success";



    }

    @RequestMapping(value = "/guidanceinsert/{id10}", method = RequestMethod.GET)
    @ResponseBody
    public String commentInsert(@PathVariable int id10, TopicGuidances topicGuidances) {
        System.out.println(topicGuidances.getTopicGuidance());
        if(topicGuidances.getTopicGuidance() == null){
            return "false";

        }

        topicGuidances.setTopicId(id10);
        topicGuidanceService.inserttopicGuidances(topicGuidances);
        return "success";



    }

    @RequestMapping(value = "/guidanceinsertlist/{id11}")
    @ResponseBody
    public MyResult guidanceInsertList(@PathVariable int id11){
        System.out.println(id11);

        MyResult result = new MyResult();
        List<TopicGuidances> list = topicGuidanceService.getguidanceInsertList(id11);
        System.out.println(list.get(0).getTopicGuidance());
        result.setTotal(topicGuidanceService.getguidanceCountByTypeId(id11));
        result.setRows(list);

        return result;

    }



}
