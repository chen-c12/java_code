package com.ddd.mybatis.test;

import com.ddd.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author Н№гу
 * @title: EmpMapper
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2316:59
 */
public interface EmpMapper {
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getById(Integer id);
}
