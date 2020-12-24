package com.design.controller;

import com.design.entity.Topic;
import com.design.entity.User;
import com.design.pojo.MyResult;
import com.design.service.TopicService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping(value = "/student/topic",method= RequestMethod.POST)
public class StudentController {
    @Value("${UPLOAD_PATH}")
    private String UPLOAD_PATH;
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

    @RequestMapping("/list")
    @ResponseBody
    public MyResult getTopicListBytopicAuditStatus() {
        MyResult result = new MyResult();
        String topicAuditStatus = "Audit";
        List<Topic> list = topicService.getTopicListBytopicAuditStatus(topicAuditStatus);
//        System.out.println(list);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getClass());
        result.setRows(list);
//        System.out.println("111111111111111111111111111111111111111111");
//        System.out.println(list.get(1).getClassName());
        result.setTotal(topicService.getTopicCount());
        return result;
    }

//    查看自己选择了的题目
    @RequestMapping("/mytopiclist")
    @ResponseBody
    public MyResult getTopicListBytopicChosenStudent(){
        System.out.println("------------------------------------------");
        MyResult result = new MyResult();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String topicChosenStudent = user.getName();
        List<Topic> list = topicService.getTopicListBytopicChosenStudent(topicChosenStudent);
        result.setRows(list);
        result.setTotal(topicService.getTopicCount());
        return result;


    }

    @RequestMapping(value = "/AssignmentBookDownload/{id2}", method = RequestMethod.GET)
    @ResponseBody
    public void Upload(@PathVariable Integer id2, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Topic topic = topicService.getTopicById(id2);

        String Totalpath = topic.getTopicAssignmentbookAddress();

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

    @RequestMapping("/Report/{id3}")
    @ResponseBody
    public String Upload(@PathVariable Integer id3, MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(id3 + "______________________________");
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
        Topic topic = topicService.getTopicById(id3);
        topic.setTopicReportAddress(UPLOAD_PATH + "/" + fileName);
        topic.setTopicReportName(fileName);
        System.out.println(UPLOAD_PATH + "/" + fileName);
        topicService.updateTopic(topic);

        return "success";

    }



}
