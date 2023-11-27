package com.ddd;

import JDBC_end.mysqldriver;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
* 封装了对于数据表的通用操作
* */
public abstract class BaseDAO<T> {
    private  Class<T> clazz = null;

    /**
     * JDBC 优化
     */
    {
        //得到父类泛型的反射
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        //强转，带参数的Type
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取了父类的泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        //获取泛型的第一个参数
        clazz = (Class<T>) actualTypeArguments[0];
    }





    /**
     *增删改操作
     * @param conn
     * @param sql
     * @param args
     */
    public int update(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            int res = ps.executeUpdate();
            return res;
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldriver.closeResource(null,ps);
        }
        return 0;
    }

    /**
     * 查询多个操作
     * @param conn
     * @param sql
     * @param args
     * @return 多条信息
     */
    public List<T> select(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> arrayList = new ArrayList<>();


            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, value);
                }
                arrayList.add(t);
            }
            return arrayList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldriver.close(null,ps,rs);
        }
        return null;
    }

    /**
     * 查询单个操作
     * @param conn
     * @param sql
     * @param args
     * @return  单条信息
     */
    public T selectone(Connection conn,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(i + 1);

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            mysqldriver.close(null,ps,rs);
        }
        return null;
    }

    /**
     * 用于查询特殊值的操作
     * @param conn
     * @param sql
     * @param args
     * @param <E>
     * @return 查询值
     */
    public <E> E getValues(Connection conn,String sql,Object ...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysqldriver.close(null,ps,rs);
        }
        return null;
    }
}
