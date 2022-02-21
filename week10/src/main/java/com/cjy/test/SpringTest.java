package com.cjy.test;

import org.testng.annotations.Test;
import com.cjy.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void Test() {
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //获取对象
        UsersService us = (UsersService) ac.getBean("usersService");
        //调用方法
        us.findUsers();
    }
}
