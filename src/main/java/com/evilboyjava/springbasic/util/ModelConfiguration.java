package com.evilboyjava.springbasic.util;
import com.evilboyjava.springbasic.model.Employee;
import com.evilboyjava.springbasic.model.EmployeeCommond;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * Created by Administrator on 14-2-9.
 */
@Configuration
@ComponentScan
public class ModelConfiguration {
    @Bean
    public EmployeeCommond employeeCommond(){
        return new EmployeeCommond();
    }

}
