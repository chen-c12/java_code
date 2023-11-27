package com.ddd.mybatis.mybatis_resultMap;

import com.ddd.mybatis.pojo.Employee;

/**
 * @author Н№гу
 * @title: Mybatis_plus
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2422:44
 */
public interface Mybatis_plus {

    public Employee getEmployeeId(Integer id);

    public Employee getEmpAndDept(Integer id);
}
