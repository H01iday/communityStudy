package com.nowcoder.communityStudy.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BetaHibernate implements BetaDao{
    @Override
    public void show() {
        System.out.println("Beta Hibernate");
    }
}
