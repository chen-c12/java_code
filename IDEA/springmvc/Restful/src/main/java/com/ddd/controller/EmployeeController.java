package com.ddd.controller;


import com.ddd.user.Employee;
import com.ddd.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author ddd
 * @title: EmployeeController
 * @projectName chen
 * @description: spring controller
 * @date 2022/1/1313:21
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    //获取所有用户信息
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    //删除用户信息
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    //对用户信息进行保存
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //得到单条信息，为修改跳转
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";

    }

    //对用户信息进行修改
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping("/response")
    @ResponseBody
    public User response(){
        return new User("chen","123456");
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String name,String password){
        System.out.println("name:"+name+"--"+"password:"+password);
        return "hello,ajax!";
    }

}
