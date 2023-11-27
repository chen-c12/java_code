package JDBC_end;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 封装了对于数据表的通用操作
 * */
public abstract class BaseDAO {

    /*增删改操作*/
    public void update(Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }

            ps.execute();

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqldriver.closeResource(null,ps);
        }
    }

    /*查询多个操作*/
    public <T> List<T> select(Connection conn, Class<T> clazz, String sql, Object ...args){
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

    /*查询单个操作*/
    public <T> T selectone(Connection conn,Class<T> clazz,String sql,Object ...args){
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

    //    用于查询特殊值的操作
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
                rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mysqldriver.close(null,ps,rs);
        }
        return null;
    }
}
