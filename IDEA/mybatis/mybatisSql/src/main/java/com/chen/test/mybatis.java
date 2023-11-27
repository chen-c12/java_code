package com.chen.test;

import com.chen.myIn.EmpMapper;
import com.chen.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Н№гу
 * @title: mybatis
 * @projectName commybatis
 * @description: TODO
 * @date 2022/1/2822:02
 */
public class mybatis {

    public SqlSessionFactory test1() throws IOException {
        String resource = "mybatisconf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = test1();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            Emp chen = new Emp(null, "chen", null, "1");
            List<Emp> empList = mapper.getEmpList(chen);
            System.out.println(empList);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = test1();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            List<Emp> getforid = mapper.getforid(Arrays.asList(1,2,3));
            System.out.println(getforid);

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = test1();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            ArrayList<Emp> emps = new ArrayList<Emp>();
            emps.add(new Emp(null,"dsd","wewk@qq.com","0"));
            emps.add(new Emp(null,"elr","dsid@qq.com","0"));
            mapper.insertEmp(emps);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

}
