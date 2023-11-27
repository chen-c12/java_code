package com.ddd.utils;

import javax.servlet.http.Cookie;

/**
 * @author ����
 * @title: CookieUtils
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/811:03
 */
public class CookieUtils {
    /**
     * ����ָ�����Ƶ�Cookie����
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name == null || cookies == null ||cookies.length==0){
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
