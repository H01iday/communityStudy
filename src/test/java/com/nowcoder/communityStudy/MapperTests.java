package com.nowcoder.communityStudy;

import com.nowcoder.communityStudy.dao.DiscussPostMapper;
import com.nowcoder.communityStudy.dao.UserMapper;
import com.nowcoder.communityStudy.entity.DiscussPost;
import com.nowcoder.communityStudy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityStudyApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        System.out.println(userMapper.selectByEmail("nowcoder101@sina.com"));
        System.out.println(userMapper.selectByName("liubei"));
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("test02");
        user.setPassword("pass");
        user.setSalt("salt");
        user.setEmail("@@");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        System.out.println(userMapper.updateStatus(151, 1));
        System.out.println(userMapper.selectById(151));
        System.out.println(userMapper.updatePassword(151,"new pass"));
        System.out.println(userMapper.selectById(151));
        System.out.println(userMapper.updateHeader(151,"http://www.nowcoder.com/102.png"));
        System.out.println(userMapper.selectById(151));
    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost post : discussPosts){
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
