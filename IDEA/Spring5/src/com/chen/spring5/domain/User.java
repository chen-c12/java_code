package com.chen.spring5.domain;

/**
 * @author Н№гу
 * @title: User
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2017:27
 */
public class User {
    private String id;
    private String user;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
