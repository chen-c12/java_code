package com.ddd;

/**
 * @author ����
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

    //ת�˵ķ���
    public void accountMoney() {
        //lucy �� 100
        dao.reduceMoney();
        //mary �� 100
        dao.addMoney();
    }




}
