package com.chen.spring5.Service;

import com.chen.spring5.Dao.UserDao;
import com.chen.spring5.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Н№гу
 * @title: UserService
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2117:57
 */
@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public void addUser(User user){
        userDao.add(user);
    }

    public void delete(String id){
        userDao.delete(id);
    }

    public void update(User user){
        userDao.update(user);
    }

    public int selectall(){
        int selecta = userDao.selecta();
        return selecta;
    }
    public User select(String id){
        User select = userDao.select(id);
        return select;
    }

    public List<User> list(){
        List<User> list = userDao.list();
        return list;
    }

    public void batch(List<Object[]> batches){
        userDao.batch(batches);
    }
}
