package com.chen.spring5.domain;

/**
 * @author Н№гу
 * @title: Person
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/228:43
 */
public class Person {
    private String aname;

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return aname;
    }
}
