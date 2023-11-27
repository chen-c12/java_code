package t_userSQL.test;

import org.junit.Test;
import t_userSQL.dao.impl.BaseDAO;
import t_userSQL.pojo.User;

import static org.junit.Assert.*;

/**
 * @author Н№гу
 * @title: BaseDAOTest
 * @projectName WebTmp
 * @description: TODO
 * @date 2021/11/1523:03
 */
public class BaseDAOTest extends BaseDAO {

    @Test
    public void queryOne() {
        String sql = "select id,username,password,email from t_user where id=?";
        System.out.println(queryOne(User.class,sql,10));
    }
}