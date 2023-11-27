package t_userSQL.dao.impl;

import t_userSQL.dao.UserDAO;
import t_userSQL.dao.impl.BaseDAO;
import t_userSQL.pojo.User;

/**
 * @author 金鱼
 * @title: UserDAOlmpl
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2516:30
 */
public class UserDAOlmpl extends BaseDAO implements UserDAO {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUserAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
