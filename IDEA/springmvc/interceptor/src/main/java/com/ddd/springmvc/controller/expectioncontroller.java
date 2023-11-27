package com.ddd.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Н№гу
 * @title: expectioncontroller
 * @projectName chen
 * @description: TODO
 * @date 2022/1/2013:50
 */
@ControllerAdvice
public class expectioncontroller {
    @ExceptionHandler(ArithmeticException.class)
    public String ArithmeticException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }
}
