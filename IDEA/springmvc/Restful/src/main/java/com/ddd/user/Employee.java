package com.ddd.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Н№гу
 * @title: Employee
 * @projectName chen
 * @description: TODO
 * @date 2022/1/1312:10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
}
