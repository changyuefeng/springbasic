package com.evilboyjava.springbasic.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 14-2-9.
 */
public class AplicationContext {
    private static ApplicationContext applicationContext = null;

    private AplicationContext() {
    }

    public synchronized static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            //applicationContext = new ClassPathXmlApplicationContext("datasources.xml");
            applicationContext = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
        }
        return applicationContext;
    }
}
