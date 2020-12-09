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
#成功登录后会有一个全局的session（见MyRealm文件的写法）

#还能实现对与登录用户的非法访问的拦截
#MyRealm中重写了doGetAuthorizationInfo方法
#具体实现方法是在doGetAuthorizationInfo方法中获取用户的个人凭证
#并将用户的个人凭证写入AuthorizationInfo对象中并提交给shiro.
#最后在applicationContext.xml中的shiroFilter中按角色对url进行角色授权管理

#AuthorizationInfo方法只在相应url验证时被调用。

#写一个被引用的div必须放在根目录下

#可以用style将样式写好，再在class中按样式名应用


         
         
         
         
 #权限管理
 #表格的导入
 
 
 
 
 #这是完全完成了登录模块功能的一个版本。
 
 #v2.0
 #包括：登陆验证、分角色页面跳转、拦截已登录用户进行跨用户角色非法登入的功能。
 
 #v3.0
 #更新了登出功能

#v4.0
#更新了左边的框

#v5.0
#該版本主要新加了easyui彈出框和一個MyBatis Generator逆向工程生成代码器

#generatorConfig.xml

##时刻注意

#实现了基本的对semester表的增删改查

#有custom的完整版本


####缺陷，还没实现分页

#v5.0.1
#添加了数据导入功能
