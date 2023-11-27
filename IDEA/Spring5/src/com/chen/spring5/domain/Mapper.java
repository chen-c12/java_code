package com.chen.spring5.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Н№гу
 * @title: Mapper
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/229:14
 */
public class Mapper {
    private String[] more;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;

    public void setMore(String[] more) {
        this.more = more;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void test(){
        System.out.println(Arrays.toString(more));
    }
}
