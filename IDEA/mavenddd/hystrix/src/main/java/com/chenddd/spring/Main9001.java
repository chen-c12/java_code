package com.chenddd.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
* Author: chenddd
* Date: 2022/6/9 11:32
* FileName: Main9001
* Description: 
*/
@SpringBootApplication
@EnableHystrixDashboard
public class Main9001 {
    public static void main(String[] args) {
        SpringApplication.run(Main9001.class,args);
    }
}
