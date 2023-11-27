package com.ddd.mybatis.test;

import com.ddd.mybatis.mybatis_resultMap.Mybatis_plus;
import com.ddd.mybatis.pojo.Department;
import com.ddd.mybatis.pojo.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Н№гу
 * @title: mybatis
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2211:25
 */
public class mybatis {

    public SqlSessionFactory get() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test() throws IOException {

        SqlSessionFactory sqlSessionFactory = get();

        SqlSession session = sqlSessionFactory.openSession();
//       try {
//            Employee selectOne = session.selectOne("com.ddd.mybatis.EmployeeMapper.selectEmp", 1);
//            System.out.println(selectOne);
//        }finally {
//            session.close();
//        }

        try{
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectEmp(1);
            System.out.println(employee);
        }finally {
            session.close();
        }
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = get();
        SqlSession session = sqlSessionFactory.openSession();

        try {
            EmpMapper mapper = session.getMapper(EmpMapper.class);
            Employee byId = mapper.getById(1);
            System.out.println(byId);
        }finally {
            session.close();
        }
    }

    @Test
    public void testadd() throws IOException {
        SqlSessionFactory sqlSessionFactory = get();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            Mybatis_plus mapper = sqlSession.getMapper(Mybatis_plus.class);
            Employee employeeId = mapper.getEmpAndDept(3);
            System.out.println(employeeId);
            System.out.println(employeeId.getDepartment());
            System.out.println(employeeId.getLast_name());


            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = get();
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee chen = mapper.select(4, "chen");
            System.out.println(chen);

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = get();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            Mybatis_plus mapper = sqlSession.getMapper(Mybatis_plus.class);
            Employee employeeId = mapper.getEmployeeId(4);
            System.out.println(employeeId);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = get();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
            Department department = mapper.getDepartment(3);
            System.out.println(department);
        }finally {
            sqlSession.close();
        }
    }
}


















