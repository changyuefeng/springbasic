package com.evilboyjava.springbasic.util;

import com.evilboyjava.springbasic.dao.CommondProcessMysqlDAO;
import com.evilboyjava.springbasic.service.CommondProcessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 14-2-9.
 */
@Configuration
@ComponentScan
public class ServiceConfiguration {
    @Bean
    public CommondProcessService commondProcessService(){
        return new CommondProcessService();
    }

}
