package com.sample.api.sample_api.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext appContext;

    public static void assignContext(String fileName) {
        if (appContext == null) {
            appContext = new ClassPathXmlApplicationContext(fileName);
        }
    }

    public static Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }

    private SpringApplicationContext() {
        
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {

       appContext = applicationContext;

    }
}
