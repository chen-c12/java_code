package com.chenddd.mail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenddd.mail.common.Result;
import com.chenddd.mail.entity.OnlyMail;

/**
 * (OnlyMail)表服务接口
 *
 * @author chenddd
 * @since 2022-11-07 11:43:31
 */
public interface OnlyMailService extends IService<OnlyMail> {

    /**
     * 根据id查找信息
     * @param id
     * @return
     */
    OnlyMail selectMailMsgById(Long id);

    /**
     * 查询全部信息
     * @return
     */
    Result selectAll();

    /**
     * 更改
     * @param onlyMail
     * @return
     */
    Result updateMail(OnlyMail onlyMail);
}

