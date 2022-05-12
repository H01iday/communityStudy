package com.nowcoder.communityStudy.service;

import com.nowcoder.communityStudy.dao.UserMapper;
import com.nowcoder.communityStudy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
