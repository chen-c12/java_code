package com.ddd.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Н№гу
 * @title: Employee
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2211:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String last_name;
    private String email;
    private String gender;
    private Department department;
}
