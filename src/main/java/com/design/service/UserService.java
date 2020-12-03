package com.design.service;


import com.design.entity.User;

public interface UserService {
    User getUserByUsername(String username);
}
