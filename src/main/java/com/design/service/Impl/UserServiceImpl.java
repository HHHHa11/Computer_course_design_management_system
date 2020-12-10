package com.design.service.Impl;


import com.design.Util.ReadExcelUtil;
import com.design.dao.UserMapper;
import com.design.dao.UserMapper;
import com.design.entity.User;
import com.design.entity.UserExample;
import com.design.entity.User;
import com.design.entity.UserExample;
import com.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        System.out.println("1");
        UserExample example = new UserExample();
        System.out.println("2");
        UserExample.Criteria criteria = example.createCriteria();
        System.out.println("3");
        criteria.andUsernameEqualTo(username);
        System.out.println("4");
        List<User> list = userMapper.selectByExample(example);
        System.out.println("5");
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;

    }


}

//    @Override
//    public String getUserById(Integer id) {
//        User user = userMapper.selectByPrimaryKey(id);
//        String result = user.getSemester();
//        return result;
//    }

    @Override
    public List<User> getUserList() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }

//    @Override
//    public List<User> getBlogTypeListByPage(int start, int rows) {
//        return blogTypeMapperCustom.getBlogTypeListByPage(start, rows);
//    }

    public int getUserCount() {
        UserExample example = new UserExample();
        return userMapper.countByExample(example);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }


//    @Override
//    public String readExcelFile(MultipartFile file) {
//        //创建处理EXCEL的类
//        ReadExcelUtil readExcel = new ReadExcelUtil();
//        //解析excel，获取上传的事件单
//        List<User> semList = null;
//        int insertResult = 0;
//        String insertMsg = "";
//        try {
//            semList = readExcel.getExcelInfo(file);
//            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
//            //和你具体业务有关,这里不做具体的示范
//            //数据库插入
//            for (User s : semList) {
//                insertResult += userMapper.insertSelective(s);
//                System.out.println(s.toString());
//            }
//            if (insertResult == 0) {
//                insertMsg = "All insert false";
//            } else if (insertResult == semList.size()) {
//                insertMsg = "All insert success";
//            } else {
//                insertMsg = "Part insert success";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println("接受excel表格中的数据失败！！！");
//        }
//        for (User s : semList) {
//            System.out.println("打印excel中的数据" + s.toString());
//        }
//        return insertMsg;
//    }
}
