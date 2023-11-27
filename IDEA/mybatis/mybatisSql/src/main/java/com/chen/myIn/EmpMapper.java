package com.chen.myIn;

import com.chen.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Н№гу
 * @title: EmpMapper
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2821:49
 */
public interface EmpMapper {

    public List<Emp> getEmpList(Emp emp);

    public List<Emp> getforid(@Param(value = "id") List<Integer> id);

    public void insertEmp(@Param(value = "emps") List<Emp> emps);

}
