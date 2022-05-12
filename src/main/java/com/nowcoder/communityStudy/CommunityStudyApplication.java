package com.nowcoder.communityStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityStudyApplication {

	public static void main(String[] args) {
		// 自动创建spring容器
		// 扫描配置类所在包及其子包的Bean
		SpringApplication.run(CommunityStudyApplication.class, args);
	}

}
