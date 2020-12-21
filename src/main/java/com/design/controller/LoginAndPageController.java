package com.design.controller;

import com.Test.Test;
import com.design.Util.CryptographyUtil;
import com.design.entity.User;
import com.design.service.CourseTypeService;
import com.design.service.SemesterTypeService;
import com.design.service.TopicService;
import com.design.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import jdk.internal.org.objectweb.asm.Type.getType;

@Controller
public class LoginAndPageController {
    @Resource
    private UserService userService;

    @Autowired
    private CourseTypeService courseTypeService;

    @Autowired
    private SemesterTypeService semesterTypeService;

    @Autowired
    private TopicService topicService;

    private final String SALT = "blog";
    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping("/teacher")
    public String teacher() {
        return "admin/teacher";
    }

    @RequestMapping("/student")
    public String student() {
        return "admin/student";
    }

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/loginUser")
    public String login(User user, HttpSession session,HttpServletRequest request) {
        Test test = new Test();
        test.UserData(user);
        test.SessionTest(request,session);
//        System.out.println("执行了loginUser请求");
//        System.out.println((String) user.getUsername());
//        Shiro对象化
        String username = user.getUsername();
        String password = user.getPassword();
//        Object passwordTomd5 = CryptographyUtil.md5(password,SALT);
        Subject subject = SecurityUtils.getSubject();
        System.out.println("执行了shiro对象化");
//        对提交的用户名和密码进行封装
        UsernamePasswordToken token = new UsernamePasswordToken(username, CryptographyUtil.md5(password, SALT));
        System.out.println("执行了用户名和密码的封装操作");
        try {
//            核心代码
//            login（）方法对封装的token方法进行验证，正确则返回true,错误则返回false
//            当进行SecurityUtils.getSubject().login()方法时，会调用Myrealm()中的登录验证方法
//            这其中的操作由在shiro的配置中配置好后进行自动调配
            System.out.println("执行了try方法");
//            System.out.println(subject.login(token).toString());
            subject.login(token);
//            这里考虑到由于shiro的安全验证登录就是基于session的增加和置空的，因此在这里
//            当验证成功后直接获取用户的整个列表然后得到身份信息并保留
            User successuser = userService.getUserByUsername(username);
            String Identity = successuser.getIdentity();
            session.setAttribute("Identity",Identity);
//            System.out.println("执行了login()方法" );
//            User successuser = userService.getUserByUsername(username);
//            test.UserData(successuser);
//            session.setAttribute("successuser",successuser);
//            test.SessionTest(request, session);
//            注意不要用redirect：/judge否则的话User中的数据不会被转发到/judge中。
            return "forward:/judge";

        } catch (Exception e) {
            System.out.println("执行了catch方法");
            e.printStackTrace();
            session.setAttribute("errorInfo", "用户名或密码错误");
        }
        return "admin/login";
    }
    @RequestMapping("/judge")
    public String judge(HttpServletRequest request,HttpSession session,User user){
        System.out.println("开始了judge请求");
        Test test = new Test();
        test.SessionTest(request,session);
        test.UserData(user);
//        System.out.println(user.getUsername());
//        SessionTest sessionTest = new SessionTest();
//        sessionTest.SessionTest(request,session);
        //        获取session
        System.out.println("6");
//        String username = user.getUsername();
//        User user = (User)session.getAttribute("user");
//        获取session
//        User user = (User)session.getAttribute("user");
////        得到user中identity的信息来决定跳转到哪个界面
//        String identity = user.getIdentity();
//        System.out.println(identity);
//        String identity = (String)session.getAttribute("identity");
//        System.out.println(identity);
        System.out.println("7");
//        不存在username(session.getAttribute("username"))
//        因此7之后会报错，在123，4之前要用到username因此4开始出错
//        User user1 = userService.getUserByUsername(username);
//        Test test = new Test();
//        test.SessionTest(request,session);
//        test.UserData(user1);
        System.out.println("8");
        String identity = session.getAttribute("Identity").toString();
        System.out.println("9");
        System.out.println(identity);
        //System.out.println(getType(identity));
        if (identity.equals("admin")) {
            System.out.println("执行了第一个if");
            return "redirect:/admin";

        } else if (identity.equals("teacher")) {
            System.out.println("执行了第二个if");
            return "redirect:/teacher";

        } else if (identity.equals("student")) {
            System.out.println("执行了第三个if");
            return "redirect:/student";
        }


        session.setAttribute("errorInfo", "没有相应权限，请联系管理员");



        return "admin/login";


    }
    @RequestMapping("/semestermanage")
    public String semestermanage(){return "admin/semestermanage";}

    @RequestMapping("/usermanage")
    public String usermanage() {
        return "admin/usermanage";
    }

    @RequestMapping("/classmanage")
    public String classmanage() {
        return "admin/classmanage";
    }

    @RequestMapping("/coursemanage")
    public String coursemanage() {
        return "admin/coursemanage";
    }

    @RequestMapping("/releasetopic")
    public String releasetopic(Model model) {
        model.addAttribute("courseTypeList", courseTypeService.getCourseTypeList());
        model.addAttribute("semesterTypeList",semesterTypeService.getSemesterTypeList());

        return "admin/releasetopic";
    }

    @RequestMapping("/topicmanage")
    public String topicmanage() {
        return "admin/topicmanage";
    }

//    @RequestMapping("/topic/{id}")
//    public String showArticle(@PathVariable int id, Model model) {
//        if (topicService.getTopicById(id)== null) {
//            return "error";
//        }
//        model.addAttribute("topic", topicService.getTopicById(id));
//        return "topic_content";
//    }
    @RequestMapping("/error")
    public String error(){return "error";}

    @RequestMapping("/article/{id}")
    public String showArticle(@PathVariable int id, Model model) {
        if (topicService.getTopicById(id) == null) {
            return "error";
        }
        model.addAttribute("topic", topicService.getTopicById(id));
        return "topic_content";
    }

    @RequestMapping("/topicshow")
    public String topicshow() {
        return "admin/topicshow";
    }

    @RequestMapping("/articlechoose/{ids}")
    public String showArticlechoose(@PathVariable int ids, Model model) {
        if (topicService.getTopicById(ids) == null) {
            return "error";
        }
        model.addAttribute("topic", topicService.getTopicById(ids));
        return "topic_content_for_choose_topic";
    }

    @RequestMapping("/alltopic")
    public String alltopic() {
        return "admin/alltopic";
    }

    @RequestMapping("/topicaudit")
    public String topicaudit() {
        return "admin/topicaudit";
    }

    @RequestMapping("/articleaudit/{ids1}")
    public String showArticleAudit(@PathVariable int ids1, Model model) {
        if (topicService.getTopicById(ids1) == null) {
            return "error";
        }
        model.addAttribute("topic", topicService.getTopicById(ids1));
        return "topic_content_for_audit";
    }

    @RequestMapping("/assignment_book")
    public String assignment_book() {
        return "admin/assignment_book";
    }

    @RequestMapping("/articleassignmentbooklist/{ids2}")
    public String showArticleAssignmentBook(@PathVariable int ids2, Model model) {
        if (topicService.getTopicById(ids2) == null) {
            return "error";
        }
        model.addAttribute("topic", topicService.getTopicById(ids2));
        return "topic_content_for_articleAssignmentBook";
    }








}


