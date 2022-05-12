package com.nowcoder.communityStudy;

import com.nowcoder.communityStudy.dao.AlphaDao;
import com.nowcoder.communityStudy.dao.BetaDao;
import com.nowcoder.communityStudy.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityStudyApplication.class)
class CommunityStudyApplicationTests implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // private ApplicationContext applicationContext;

	// 这个方法转传进来的 applicationContext 就是spring容器
	// @Override
	// public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	// 	this.applicationContext = applicationContext;
	// }

	// @Test
	// public void testApplicationContext(){
	// 	AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
	// 	System.out.println(alphaDao.select());
	// }

    @Test
    public void testBeta(){
        // 第一次输出优先级高那个
        BetaDao betaDao = applicationContext.getBean(BetaDao.class);
        betaDao.show();
        // 第二次指定了名字
        betaDao = applicationContext.getBean("betaHibernate", BetaDao.class);
        betaDao.show();
    }

    @Test
    public void testBeanManagement(){
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    @Autowired
    @Qualifier("alphaHibernate")
    private AlphaDao alphaDao;

    @Test
    public void testDI(){
        System.out.println(alphaDao.select());
    }
}
