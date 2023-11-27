package com.chen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Н№гу
 * @title: Emp
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2821:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String last_name;
    private String email;
    private String gender;
//    private Dept department;
}
