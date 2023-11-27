package t_userSQL.service;

import t_userSQL.pojo.User;

/**
 * @author 金鱼
 * @title: UserService
 * @projectName Java_Web
 * @description: TODO
 * @date 2021/9/279:10
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回null表示登录失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
