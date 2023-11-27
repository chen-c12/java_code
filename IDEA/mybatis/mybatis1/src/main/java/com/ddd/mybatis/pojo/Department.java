package com.ddd.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Н№гу
 * @title: Department
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2423:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Integer id;
    private String departmentName;
    private List<Employee> emps;


}
