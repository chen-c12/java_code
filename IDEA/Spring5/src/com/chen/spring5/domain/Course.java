package com.chen.spring5.domain;

/**
 * @author Н№гу
 * @title: Course
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2210:46
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
