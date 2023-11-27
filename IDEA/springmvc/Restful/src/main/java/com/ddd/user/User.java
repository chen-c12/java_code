package com.ddd.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ����
 * @title: User
 * @projectName chen
 * @description: TODO
 * @date 2022/1/1715:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String password;

}
