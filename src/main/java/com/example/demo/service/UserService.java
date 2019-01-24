package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;
    public User getUser(Integer id){
        return mapper.selectByPrimaryKey(id);
    }

    public int addUser(User user){
        return mapper.insert(user);
    }
}
