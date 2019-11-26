package com.qin.apps.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.qin.apps.cms.dao")
public class MybatisConfig {

}
