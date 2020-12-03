package com.design.dao;


import com.design.entity.User;
import com.design.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {


    List<User> selectByExampleWithBLOBs(UserExample example);

}