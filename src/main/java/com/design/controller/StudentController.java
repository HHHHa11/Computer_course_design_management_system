package com.design.controller;

import com.design.Util.CryptographyUtil;
import com.design.entity.Topic;
import com.design.entity.TopicGuidances;
import com.design.entity.User;
import com.design.pojo.MyResult;
import com.design.service.TopicGuidanceService;
import com.design.service.TopicService;
import com.design.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping(value = "/student/topic",method= RequestMethod.POST)
public class StudentController {
    private final String SALT = "blog";
    @Value("${UPLOAD_PATH}")
    private String UPLOAD_PATH;
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicGuidanceService topicGuidanceService;
    @Autowired
    private UserService userService;


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


    @RequestMapping(value = "/guidanceinsertlist/{id4}")
    @ResponseBody
    public MyResult guidanceInsertList(@PathVariable int id4) {
        System.out.println(id4);

        MyResult result = new MyResult();
        List<TopicGuidances> list = topicGuidanceService.getguidanceInsertList(id4);
        System.out.println(list.get(0).getTopicGuidance());
        result.setTotal(topicGuidanceService.getguidanceCountByTypeId(id4));
        result.setRows(list);

        return result;

    }

    @RequestMapping(value = "/updatePassword/{id5}")
    @ResponseBody
    public String updatePassword(@PathVariable int id5, @RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword1") String newpassword1, @RequestParam("newpassword2") String newpassword2, HttpSession session) {
        System.out.println(oldpassword);
        System.out.println(newpassword1);
        System.out.println(newpassword2);
        System.out.println(((User) session.getAttribute("user")).getPassword());

        String oldpasswordformd5 = CryptographyUtil.md5(oldpassword, SALT);
        System.out.println(((User) session.getAttribute("user")).getPassword());
//        如果两个新密码不一样的话，就报错
        if(newpassword1.equals(newpassword2) == false){
            System.out.println("newpasswordsame:1");
            return "newpasswordsame";
        }else if(oldpassword.equals(newpassword1)){
            System.out.println("different:1");
            return "different";
        }else if (oldpasswordformd5.equals(((User) session.getAttribute("user")).getPassword())){
            User user = userService.getUserById(id5);
            user.setPassword(CryptographyUtil.md5(newpassword1, SALT));
            userService.updateUser(user);
            return "success";

        }
//        User user = userService.getUserById(id5);

//        user.setPassword(CryptographyUtil.md5(password, SALT));
//        userService.updateUser(user);
        return "false";
    }





}
