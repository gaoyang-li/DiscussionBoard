package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public User findById(Long id){
        return userMapper.findById(id);
    }

    public void insert(User user){
        userMapper.insert(user);
    }

    public void update(Long id, User user){
        userMapper.update(id, user);
    }

    public void delete(Long id){
        userMapper.delete(id);
    }
}
