package com.chenddd.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chenddd
 * Date: 2022/4/14 15:00
 * FileName: Role
 * Description: 角色类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String nameZh;
}
