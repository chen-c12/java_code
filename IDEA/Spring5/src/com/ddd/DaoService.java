package com.ddd;

/**
 * @author 金鱼
 * @title: DaoService
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2716:19
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DaoService {
    @Autowired
    private Dao dao;

    //转账的方法
    public void accountMoney() {
        //lucy 少 100
        dao.reduceMoney();
        //mary 多 100
        dao.addMoney();
    }




}
