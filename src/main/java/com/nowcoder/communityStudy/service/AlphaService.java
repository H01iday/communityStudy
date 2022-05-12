package com.nowcoder.communityStudy.service;

import com.nowcoder.communityStudy.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class AlphaService {

    @Autowired
    private  AlphaDao alphaDao;

    public AlphaService(){
        System.out.println("实例化...");
    }


    // 构造器之后调用
    @PostConstruct
    public void init(){
        System.out.println("初始化...");
    }

    // 销毁对象之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("销毁...");
    }

    public String find(){
        return alphaDao.select();
    }

}
