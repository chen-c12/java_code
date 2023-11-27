package com.ddd.mybatis.test;

import com.ddd.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Н№гу
 * @title: EmployeeMapper
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2220:58
 */
public interface EmployeeMapper {

    public Employee selectEmp(Integer id);

    public Employee select(@Param("id") Integer id,@Param("last_name")String last_name);

    public Integer addEmp(Employee employee);

    public Integer deleteEmp(Integer id);

    public Boolean updateEmp(Employee employee);

    public List<Employee>  getEmpById(Integer id);

}
