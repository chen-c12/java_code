package com.chenddd.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chenddd
 * Date: 2022/4/11 16:57
 * FileName: IndexController
 * Description:
 */
@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        System.out.println("hello index");
        return "hello index";
    }
}
