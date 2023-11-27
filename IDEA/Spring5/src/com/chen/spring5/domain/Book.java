package com.chen.spring5.domain;

/**
 * @author Н№гу
 * @title: Book
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2111:30
 */
public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public void showBook(){
        System.out.println(name+"++"+author);
    }
}
