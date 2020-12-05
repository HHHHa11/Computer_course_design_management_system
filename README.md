#实验小田地


##建文件夹之前先搞好四个包：
##controller、dao、pojo、service

#WEB-INF下的页面不能够直接按照地址访问（出于安全问题）
#而要在Controller中调用

#要配置好<mvc：interceptors>

#    <mvc:interceptors>
         <mvc:interceptor>
             <mvc:mapping path="/**" />
             
             
             <mvc:exclude-mapping path="/"/>
             <mvc:exclude-mapping path="/index"/>
             <mvc:exclude-mapping path="/login"/>
             <!--    从分析来看这个interceptos是拦截所有请求，在console中可以看到拦截了配置好的-->
             <!--    /static/下的文件，因此把这个也加上-->
             <mvc:exclude-mapping path="/static/**"/>
             <!--      登录请求不拦截，但是会有漏洞：请求表单      -->
             <mvc:exclude-mapping path="/loginUser"/>
             <bean class="com.design.Inbterceptor.AdminResourceInterceptor"/>
         </mvc:interceptor>
         
#做单点登录时遇到的坑：在shiro验证中需要到User的username和password进行加密验证
#shiro验证的核心是以session为核心的验证

#该版本只是实现了最基本的分角色登录



         
         
         
         
 #权限管理
 #表格的导入
