package com.begin.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 设置Ribbon负载均衡规则
 * @author 83456
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        /**
         * 定义为随机
         * */
        return  new RandomRule();
    }
}
