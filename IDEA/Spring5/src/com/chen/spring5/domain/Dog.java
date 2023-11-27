package com.chen.spring5.domain;

/**
 * @author Н№гу
 * @title: Dog
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/228:44
 */
public class Dog {
    private String dname;
    private String dage;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setDage(String dage) {
        this.dage = dage;
    }

    public void testdog(){
        System.out.println(dage+dname+person);
    }
}
