package t_userSQL.service.Impl;

import t_userSQL.dao.UserDAO;
import t_userSQL.dao.impl.UserDAOlmpl;
import t_userSQL.pojo.User;
import t_userSQL.service.UserService;

/**
 * @author 金鱼
 * @title: UserServiceImpl
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/279:20
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOlmpl();
    @Override
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUserAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDAO.queryUserByUsername(username)==null){
            //没查到，表示可用
            return false;
        }
        return true;
    }
}
