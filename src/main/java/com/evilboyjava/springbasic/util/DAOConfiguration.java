package com.evilboyjava.springbasic.util;

import com.evilboyjava.springbasic.dao.CommondProcessMysqlDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DAOConfiguration {
    @Bean
    public CommondProcessMysqlDAO commondProcessMysqlDAO(){
        return new CommondProcessMysqlDAO();
    }

}
