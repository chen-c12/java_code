package com.ddd.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Н№гу
 * @title: TestController
 * @projectName chen
 * @description: TODO
 * @date 2021/12/416:44
 */

@Controller
public class TestController {

    @RequestMapping("/test")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping(value = "/test_get",method = RequestMethod.GET)
    public String getid(){
        System.out.println("select id");
        return "success";
    }

    @RequestMapping("/form")
    public String form(){
        return "form";
    }

    @RequestMapping(value = "/test_put",method = RequestMethod.PUT)
    public String putid(){
        System.out.println("put id");
        return "success";
    }
}
