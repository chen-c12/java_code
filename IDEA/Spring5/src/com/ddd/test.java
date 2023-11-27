package com.ddd;

/**
 * @author Н№гу
 * @title: test
 * @projectName Spring5
 * @description: TODO
 * @date 2021/11/2815:44
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class test {

    @Autowired
    private DaoService daoService;

    @Test
    public void test(){
        daoService.accountMoney();
    }

}
