package com.chenddd.mail.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenddd.mail.common.Result;
import com.chenddd.mail.dao.OnlyMailDao;
import com.chenddd.mail.entity.OnlyMail;
import com.chenddd.mail.service.OnlyMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OnlyMail)表服务实现类
 *
 * @author chenddd
 * @since 2022-11-07 11:43:31
 */
@Service("onlyMailService")
public class OnlyMailServiceImpl extends ServiceImpl<OnlyMailDao, OnlyMail> implements OnlyMailService {

    @Resource
    private OnlyMailDao onlyMailDao;


    @Override
    public OnlyMail selectMailMsgById(Long id) {
        OnlyMail onlyMail = onlyMailDao.selectById(id);
        return onlyMail;
    }


    @Override
    public Result selectAll() {
        List<OnlyMail> onlyMails = onlyMailDao.selectList(null);
        return onlyMails!=null ? Result.ok(onlyMails) : Result.fail();
    }

    @Override
    public Result updateMail(OnlyMail onlyMail) {
        int i = onlyMailDao.updateById(onlyMail);
        return i==0?Result.fail("修改失败"):Result.ok("修改成功");
    }

}

