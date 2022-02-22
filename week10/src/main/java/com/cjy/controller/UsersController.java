package com.cjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @RequestMapping("/findUsers")
    public String findUsers(){
        System.out.println("表现层：查询用户");
        return "Users";
    }
}
