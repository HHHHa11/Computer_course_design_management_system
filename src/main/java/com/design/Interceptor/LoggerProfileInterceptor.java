//package com.design.Interceptor;
//
////import com.jndj.platform.system.operateLog.entity.OperateLog;
////import com.jndj.platform.system.operateLog.service.OperateLogService;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//public class OperateLogAspect {
//
//    @Autowired
//    private OperateLogService operateLogService;
//
//    // 定义切点 @Pointcut
//    // 在注解的位置切入代码
//    @Pointcut("@annotation(com.jndj.platform.common.annotation.LoggerOperator)")
//    public void operateLogPointCut() {
//    }
//
//    // 配置切面通知
//    @AfterReturning("operateLogPointCut()")
//    public void saveOperateLog(JoinPoint joinPoint) {
//        //保存日志
//        OperateLog operateLog = new OperateLog();
//
//        // 从切面植入点处通过反射机制获取植入点处的方法
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        //获取切入点所在的方法
//        Method method = signature.getMethod();
//
//        // 获取操作
//        LoggerOperator userOperateLog = method.getAnnotation(LoggerOperator.class);
//        if (userOperateLog != null) {
//            String content = userOperateLog.content();
//            operateLog.setOperateContent(content);  //保存获取的操作内容
//        }
//
//        // 获取请求的类名、方法名
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = method.getName();
//        operateLog.setOperate(className + "." + methodName); //保存获取的类名、方法名
//
//        // 获取请用的用户名
//        HttpServletRequest request =
//                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession(true);
//        if (session != null) {
//            String userName = (String) session.getAttribute("username");
//            operateLog.setUsername(userName);
//        }
//        // 记录操作时间
//        operateLog.setTime(DateUtils.getCurrDateTimeStamp());
//
//        //调用service保存实体类到数据库
//        operateLogService.save(operateLog);
//    }
//}
