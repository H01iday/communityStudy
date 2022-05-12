package com.nowcoder.communityStudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {

    // 这个方法返回的对象将会被装配到Bean中
    // 将SimpleDateFormat实例化一次，放到Bean中，能够反复使用
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy--MM--dd HH:mm:ss");
    }

}
