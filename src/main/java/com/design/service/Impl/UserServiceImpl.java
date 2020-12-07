package com.design.service.Impl;


import com.design.dao.UserMapper;
import com.design.entity.User;
import com.design.entity.UserExample;
import com.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public User getUserByUsername(String username) {
        System.out.println("1");
        UserExample example = new UserExample();
        System.out.println("2");
        UserExample.Criteria criteria = example.createCriteria();
        System.out.println("3");
        criteria.andUsernameEqualTo(username);
        System.out.println("4");
        List<User> list = UserMapper.selectByExampleWithBLOBs(example);
        System.out.println("5");
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;

    }


}
}
