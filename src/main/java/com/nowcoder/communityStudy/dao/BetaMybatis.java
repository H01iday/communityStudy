package com.nowcoder.communityStudy.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BetaMybatis implements BetaDao{

    @Override
    public void show() {
        System.out.println("Beta Mybatis");
    }
}
