package com.chenddd.Http;

import java.io.Serializable;

/**
 * @author Н№гу
 * @title: HttpClientResp
 * @projectName jedis_redis
 * @description: TODO
 * @date 2022/3/2714:02
 */
public class HttpClientResp implements Serializable {
    private static final long serialVersionUID = 2168152194164783950L;
    private int code;
    private String content;

    public HttpClientResp() {
    }

    public HttpClientResp(int code) {
        this.code = code;
    }

    public HttpClientResp(String content) {
        this.content = content;
    }

    public HttpClientResp(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpClientResp{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }
}
