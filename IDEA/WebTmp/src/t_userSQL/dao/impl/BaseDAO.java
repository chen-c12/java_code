package t_userSQL.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 金鱼
 * @title: BaseDAO
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2515:25
 */
public abstract class BaseDAO {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     *
     * @param sql
     * @param args
     * @return 返回-1说明执行失败，返回其他表示影响的行数
     */
    public int update(String sql,Object ...args){
        Connection conn = null;
        try {
            conn = Jdbcutils.conn();
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return  返回单个查询数据
     */
    public <T> T queryOne(Class<T> clazz,String sql,Object ...args){
        Connection conn = null;
        try {
            conn = Jdbcutils.conn();
            return  queryRunner.query(conn,sql,new BeanHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return 返回多个数据
     */
    public <T>  List<T> queryList(Class<T> clazz,String sql,Object ...args){
        Connection conn = null;
        try {
            conn = Jdbcutils.conn();
            return  queryRunner.query(conn,sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param sql
     * @param args
     * @return 返回特殊语句查询
     */
    public Object selectAll(String sql,Object ...args){
        Connection conn = null;
        try {
            conn = Jdbcutils.conn();
            return queryRunner.query(conn,sql, new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
