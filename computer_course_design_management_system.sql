/*
 Navicat Premium Data Transfer

 Source Server         : public
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : computer_course_design_management_system

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 10/12/2020 13:27:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `click_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reply_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `like_count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `blog_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reprint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('299', 'CSDN如何转载别人的文章', '对于喜欢逛CSDN的人来说，看别人的博客确实能够对自己有不小的提高，有时候看到特别好的博客想转载下载，但是不能一个字一个字的敲了，这时候我们就想快速转载别人的博客，把别人的博客移到...', '2018-12-11 14:32:00', '2018-12-12 17:00:17', '12', '1', '2', '8', '<svg xmlns=\"http://www.w3.org/2000/svg\" style=\"display: none;\"><path stroke-linecap=\"round\" d=\"M5,0 0,2.5 5,5z\" id=\"raphael-marker-block\" style=\"-webkit-tap-highlight-color: rgba(0, 0, 0, 0);\"></path></svg>\r\n<p>  对于喜欢逛CSDN的人来说，看别人的博客确实能够对自己有不小的提高，有时候看到特别好', NULL, 'https://blog.csdn.net/bolu1234/article/details/51867099');
INSERT INTO `blog` VALUES ('301', 'Java 之 BASE64 加密解密', '背景在给邮件发送URL链接找回密码时，会发送一个链接，像这样http://localhost:8080/resetpass?sid=c1b55b980db4eb74a4264a92...', '2018-12-11 16:47:53', '2018-12-12 16:59:20', '2', '0', '2', '5', '# 背景\r\n\r\n在给邮件发送 URL 链接找回密码时，会发送一个链接，像这样\r\n\r\nhttp://localhost:8080/resetpass?sid=c1b55b980db4eb74a4264a92d53cd953&account=saysky\r\n\r\n验证原理就是，当用户点击链接，然后请求 控制器里的 resetpass 方法，获得 sid(密钥) 和 account(用户名) 两个参数。根据用户名去数据库中的 “邮件找回密码” 表(mail_retrieve)里寻找记录，获得 mailRetrie', NULL, 'https://liuyanzhao.com/7578.html');
INSERT INTO `blog` VALUES ('302', 'JAVA 对象的序列化', '下面将介绍对象的序列化——一种将对象转成字节方便传送到别处或存储在硬盘上，并且再从转化成的字节重构对象的机制。序列化是分布式管理必备的工具，分布式处理中将对象从一个虚拟传到另一个虚...', '2018-12-11 17:12:41', '2018-12-11 17:16:00', '2', '0', '2', '5', '　　下面将介绍对象的序列化——一种将对象转成字节方便传送到别处或存储在硬盘上，并且再从转化成的字节重构对象的机制。\r\n\r\n　　序列化是分布式管理必备的工具，分布式处理中将对象从一个虚拟传到另一个虚拟机。序列化也被用于故障转移和负载均衡方面，序列化对象可以从一个服务器移到另一个服务器。如果你开发过服务器端软件，就会经常需要序列化。下面介绍如何序列化。(摘自 《Core Java》)\r\n  \r\n  ## 一、简单的一个例子\r\n  \r\n  Person.java\r\n  \r\n  ```java\r\nimport j', '/static/userImage/2018/12/11/63f39dc2-e40c-47b0-91e8-aa1f8f5d1cf3.jpg', 'https://liuyanzhao.com/7649.html');
INSERT INTO `blog` VALUES ('303', '图解排序算法(四)之归并排序', '基本思想归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问...', '2018-12-11 17:22:38', '2018-12-12 16:58:49', '3', '0', '1', '10', '## 基本思想\r\n\r\n　　归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案\"修补\"在一起，即分而治之)。\r\n  \r\n### 分而治之\r\n\r\n![](/static/userImage/2018/12/11/9df9962f-5578-41cc-8693-c10fa245e566.png)\r\n\r\n可以看到这种结构很像一', '/static/userImage/2018/12/11/0f228359-0fe7-4cbe-b6d8-06e57a91f1e7.png', 'http://www.cnblogs.com/chengxiao/p/6194356.html');
INSERT INTO `blog` VALUES ('304', 'Oracle约束(Constraint)详解', '概述约束是数据库用来确保数据满足业务规则的手段，不过在真正的企业开发中，除了主键约束这类具有强需求的约束，像外键约束，检查约束更多时候仅仅出现在数据库设计阶段，真实环境却很少应用，...', '2018-12-11 17:47:07', '2018-12-11 17:54:19', '3', '0', '1', '9', '## 概述\r\n\r\n　　约束是数据库用来确保数据满足业务规则的手段，不过在真正的企业开发中，除了主键约束这类具有强需求的约束，像外键约束，检查约束更多时候仅仅出现在数据库设计阶段，真实环境却很少应用，更多是放到程序逻辑中去进行处理。这也比较容易理解，约束会一定程度上较低数据库性能，有些规则直接在程序逻辑中处理就可以了，同时，也有可能在面对业务变更或是系统扩展时，数据库约束会使得处理不够方便。不过在我看来，数据库约束是保证数据准确性的最后一道防线，对于设计合理的系统，处于性能考虑数据库约束自然可有可无；不过若', '/static/userImage/2018/12/11/fad2df09-f4a2-4cea-bb5a-2b90d40ab69b.png', 'https://www.cnblogs.com/chengxiao/p/6032183.html');
INSERT INTO `blog` VALUES ('305', 'Java之美[从菜鸟到高手演练]之Linux篇——Linux下JDK、Ruby、Node.js等runtime的安装', '我们常常工作在Linux下，所以必须要学会安装这些常用的runtime，这些工作都是相通的，学会一种，其他的举一反三就OK了！一般来说，有三种方法：使用包管理器，像ruby的rvm...', '2018-12-11 22:44:13', '2018-12-11 22:44:13', '3', '0', '2', '7', '我们常常工作在Linux下，所以必须要学会安装这些常用的runtime，这些工作都是相通的，学会一种，其他的举一反三就OK了！\r\n\r\n一般来说，有三种方法：\r\n1. 使用包管理器，像ruby的rvm（推荐）\r\n2. 直接安装二进制包\r\n3. 从源码包进行编译安装\r\n\r\n三种方法都比较简单，除了安装步骤外，还有一个重要的步骤就是在安装完后配置环境变量。下面我举例说明下：\r\n\r\n**Linux下安装Java**\r\n\r\nJava的安装不需要使用特定的包管理器，直接在Oracle官网上下载二进制包，形如：jdk-', NULL, 'https://blog.csdn.net/zhangerqing/article/details/8609178');
INSERT INTO `blog` VALUES ('306', 'Java之美[从菜鸟到高手演练]之Linux篇——压缩及解压缩命令tar的使用', '这些命令使用很常见，我们需要长记在心，直接总结下吧：tar[-cxtzjvfpPN]文件与目录….参数：-c：建立一个压缩文件的参数指令-x：解开一个压缩文件的参数指令-t：查看压...', '2018-12-11 22:56:38', '2018-12-11 23:00:46', '3', '0', '1', '7', '这些命令使用很常见，我们需要长记在心，直接总结下吧：\r\ntar [-cxtzjvfpPN] 文件与目录 ....\r\n\r\n参数：\r\n-c ：建立一个压缩文件的参数指令\r\n-x ：解开一个压缩文件的参数指令\r\n-t ：查看压缩文件里面的文件\r\n\r\n**特别注意：** c/x/t 同时只能存在一个，原因是我们不可能同时压缩与解压缩。\r\n\r\n-z ：是否同时具有 gzip 的属性？亦即是否需要用 gzip 压缩\r\n-j ：是否同时具有 bzip2 的属性？亦即是否需要用 bzip2 压缩\r\n-v ：压缩的过程中显', NULL, 'https://blog.csdn.net/zhangerqing/article/details/8609233');
INSERT INTO `blog` VALUES ('307', 'Java之美[从菜鸟到高手演练]之Linux篇——Linux下比较重要的8个命令', '摘要:Linux里有很丰富的各种命令，有些是很难用的。然而，学会了前面说的这8个命令，你已经能处理大量的log分析任务了，完全不需要用脚本语言写程序来处理它们。每个程序员，在职业生...', '2018-12-11 23:14:43', '2018-12-11 23:24:24', '5', '1', '0', '7', '>	**摘要: **Linux里有很丰富的各种命令，有些是很难用的。然而，学会了前面说的这8个命令，你已经能处理大量的log分析任务了，完全不需要用脚本语言写程序来处理它们。\r\n\r\n每个程序员，在职业生涯的某个时刻，总会发现自己需要知道一些Linux方面的知识。我并不是说你应该成为一个Linux专家，我的意思是，当面对Linux命令行任务时，你应该能很熟练的完成。事实上，学会了下面8个命令，我基本上能完成任何需要完成的任务。\r\n\r\n注意：下面的每个命令都有十分丰富的文档说明。这篇文章并不是来详尽的展示每个', NULL, 'https://blog.csdn.net/zhangerqing/article/details/8545715>');
INSERT INTO `blog` VALUES ('308', 'EasyUI分页的实现', '使用$.fn.pagination.defaults重写默认值对象该分页控件允许用户导航页面的数据。它支持页面导航和页面长度选择的选项设置。用户可以在分页控件上添加自定义按钮，以增...', '2018-12-11 23:54:15', '2018-12-12 16:57:31', '14', '4', '4', '6', '使用$.fn.pagination.defaults重写默认值对象\r\n\r\n该分页控件允许用户导航页面的数据。它支持页面导航和页面长度选择的选项设置。用户可以在分页控件上添加自定义按钮，以增强其功能。\r\n\r\n![](http://localhost:8081/static/userImage/2018/12/11/ec4fdd79-9fb3-422f-896c-43dd8ee9edbf.png)\r\n\r\n**使用案例**\r\n\r\n使用标签创建分页控件。\r\n\r\n```html\r\n<div id=\"pp\" clas', '/static/userImage/2018/12/12/73b4ceb2-9d61-45d6-bfca-7c9715dc10fc.jpg', '');
INSERT INTO `blog` VALUES ('312', '关于这次实验的一些感悟', '在这次的学习之中，着重体现的是ssm框架，而实际上这次学习中我还用到了诸如:EasyUI、Bootstrap的框架，而前面的浏览页面主要是参考了简书主页的框架，而后面的后台管理则借...', '2020-03-18 23:09:02', '2020-03-19 00:49:51', '17', '2', '4', '8', '在这次的学习之中，着重体现的是ssm框架，而实际上这次学习中我还用到了诸如:EasyUI、Bootstrap的框架，而前面的浏览页面主要是参考了[简书](https://www.jianshu.com/ \"简书\")主页的框架，而后面的后台管理则借用了 EasyUI和Bootstrap。\r\n在jsp界面上把界面写好之后主要是要把引用的数据(用到mybatis和myssql)和需要展示的和跳转的界面(herf=)表示出来(contrller和mapper的任务)。\r\n最后通过配置文件来调用各个框架包（这里用到', '/static/userImage/2020/03/19/39258d9e-57af-4adc-8da8-8bfcf74ccc5d.jpg', '');
INSERT INTO `blog` VALUES ('313', '使用Navicat Premium创建MySQL数据库', '工具/原料示例数据库：MySQL5.7示例版本：NavicatPremium11.0.17（windows）运行“NavicatPremium”数据库管理工具。新建MySQL数据库...', '2020-04-26 08:45:50', '2020-04-26 08:48:53', '7', '0', '0', '9', '<div class=\"entry-content clearfix\"> \r\n<div style=\"margin-bottom: : 5px;\"> \r\n\r\n</div>\r\n    <h2>\r\n    工具/原料</h2>\r\n<p>示例数据库：MySQL 5.7</p>\r\n<p>示例版本：Navicat Premium 11.0.17（windows）</p>\r\n<p>运行“Navicat Premium”数据库管理工具。</p>\r\n<p><a href=\"https://www.gwygd.com/up', NULL, 'https://www.gwygd.com/g96g2kXVk.html');
INSERT INTO `blog` VALUES ('314', '2018科大讯飞AI营销算法大赛总结（冠军）', '作者介绍：王贺，武汉大学，计算机专业，研二写在前面首先很幸运能够拿到这次冠军，有两位大佬队友是这次获胜的关键，再次感谢鹏哥和阿水。同时希望我的分享与总结能给大家带来些许帮助，并且一...', '2020-06-01 12:08:12', '2020-06-01 12:08:12', '9', '0', '0', '11', '<div class=\"rich_media_content\" id=\"js_content\">\r\n                    \r\n\r\n                    \r\n\r\n                    \r\n                    \r\n                    <h2 style=\"font-family:\'-apple-system\', BlinkMacSystemFont, \'Helvetica Neue\', \'PingFang SC\', ', NULL, 'https://blog.csdn.net/kmd8d5r/article/details/83552360');
INSERT INTO `blog` VALUES ('315', '11', '123...', '2020-06-20 17:22:41', '2020-06-20 17:22:41', '3', '1', '0', '5', '123', NULL, '12');

-- ----------------------------
-- Table structure for class_type
-- ----------------------------
DROP TABLE IF EXISTS `class_type`;
CREATE TABLE `class_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_type
-- ----------------------------
INSERT INTO `class_type` VALUES (1, '计算机17-1');

-- ----------------------------
-- Table structure for semester_type
-- ----------------------------
DROP TABLE IF EXISTS `semester_type`;
CREATE TABLE `semester_type`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `semester` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `semester`(`semester`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of semester_type
-- ----------------------------
INSERT INTO `semester_type` VALUES (58, '2018-2019-21');
INSERT INTO `semester_type` VALUES (59, '2018-2019-22');
INSERT INTO `semester_type` VALUES (60, '2018-2019-23');
INSERT INTO `semester_type` VALUES (61, '2018-2019-24');
INSERT INTO `semester_type` VALUES (62, '2018-2019-25');
INSERT INTO `semester_type` VALUES (63, '2018-2019-26');
INSERT INTO `semester_type` VALUES (64, '2018-2019-27');
INSERT INTO `semester_type` VALUES (65, '2018-2019-28');
INSERT INTO `semester_type` VALUES (66, '2018-2019-29');
INSERT INTO `semester_type` VALUES (67, '2018-2019-30');
INSERT INTO `semester_type` VALUES (68, '2018-2019-31');
INSERT INTO `semester_type` VALUES (69, '2018-2019-32');
INSERT INTO `semester_type` VALUES (70, '2018-2019-33');
INSERT INTO `semester_type` VALUES (71, '2018-2019-34');
INSERT INTO `semester_type` VALUES (72, '2018-2019-35');
INSERT INTO `semester_type` VALUES (73, '2018-2019-36');
INSERT INTO `semester_type` VALUES (74, '2018-2019-37');
INSERT INTO `semester_type` VALUES (75, '2018-2019-38');
INSERT INTO `semester_type` VALUES (76, '2018-2019-39');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(32) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人姓名',
  `student_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学号',
  `classes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级，示例：计算机17-1',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份，示例：teacher,student,admin',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '小红', NULL, '', NULL, NULL, 'admin', '3facf26687dab7254848976256edb56f', 'admin');
INSERT INTO `user` VALUES (2, '小黑', '', '', '', '', 'admin1', '3facf26687dab7254848976256edb56f', 'admin');
INSERT INTO `user` VALUES (3, '小白', NULL, NULL, NULL, NULL, '17034480134', '54ce5e65c4a2ef833c270600176a39c9', 'student');
INSERT INTO `user` VALUES (4, '小空', NULL, NULL, NULL, NULL, '606300', '54ce5e65c4a2ef833c270600176a39c9', 'teacher');
INSERT INTO `user` VALUES (6, '吴家剑', '17034480134', '计算机17-1', '男', '1150878978@qq.com', '17034480133', '54ce5e65c4a2ef833c270600176a39c9', 'student');

SET FOREIGN_KEY_CHECKS = 1;
