package t_userSQL.dao;

import t_userSQL.pojo.User;

/**
 * @author 金鱼
 * @title: UserDAO
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/2516:22
 */
public interface UserDAO {

    /**
     *
     * @param username
     * @return 如果返回null，说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return  返回null说明用户名或密码错误
     */
    public User queryUserByUserAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);
}
