package com.chenddd.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: chenddd
 * Date: 2022/4/12 14:58
 * FileName: LogoutController
 * Description:
 */
@Controller
public class LogoutController {

    @RequestMapping("/logout.html")
    public String logout() {
        return "logout";
    }
}
