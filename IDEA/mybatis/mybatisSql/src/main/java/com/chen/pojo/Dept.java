package com.chen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Н№гу
 * @title: Dept
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2821:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;
    private String departmentName;
    private List<Emp> emps;
}
