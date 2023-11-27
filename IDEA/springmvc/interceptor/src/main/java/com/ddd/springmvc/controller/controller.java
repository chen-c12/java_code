package com.ddd.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Н№гу
 * @title: controller
 * @projectName chen
 * @description: spring controller
 * @date 2022/1/1822:33
 */
@Controller
public class controller {
    @RequestMapping("testinterceptor")
    public String testInterceptor(){
        System.out.println(1/0);
        return "success";
    }
}
