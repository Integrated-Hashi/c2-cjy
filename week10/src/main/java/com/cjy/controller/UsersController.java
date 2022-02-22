package com.cjy.controller;

import com.cjy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("/findUsers")
    public String findUsers(){
        System.out.println("表现层：查询用户");
        usersService.findUsers();
        return "Users";
    }
}
