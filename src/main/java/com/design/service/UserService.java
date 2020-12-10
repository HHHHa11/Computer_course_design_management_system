package com.design.service;


import com.design.entity.User;
import com.design.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

//    String getUserById(Integer id);

    List<User> getUserList();

    //    List<User> getUserListByPage(int start, int rows);
    int getUserCount();

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

//    public String readExcelFile(MultipartFile file);
}
