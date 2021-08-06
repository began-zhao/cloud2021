package com.begin.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 83456
 */
@Configuration
@MapperScan({"com.begin.springcloud.dao"})
public class MyBatisConfig {
}
