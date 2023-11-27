package com.chenddd.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chenddd
 * Date: 2022/4/11 22:42
 * FileName: LoginController
 * Description:
 */
@Controller
public class LoginController {

    @RequestMapping("/login.html")
    public String loginPage() {
        return "login";
    }


}
