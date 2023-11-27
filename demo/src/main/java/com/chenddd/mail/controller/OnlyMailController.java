package com.chenddd.mail.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenddd.mail.common.Result;
import com.chenddd.mail.email.SendEmail;
import com.chenddd.mail.entity.OnlyMail;
import com.chenddd.mail.service.OnlyMailService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (OnlyMail)表控制层
 *
 * @author chenddd
 * @since 2022-11-07 11:43:31
 */
@RestController
@RequestMapping("/onlyMail")
public class OnlyMailController {

    @Resource
    private OnlyMailService onlyMailService;
    @Resource
    private SendEmail sendEmail;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getMailById(@PathVariable("id") Long id){
        OnlyMail onlyMail = onlyMailService.selectMailMsgById(id);
        if (ObjectUtils.isEmpty(onlyMail)){
            return Result.fail("查询失败");
        }
        return Result.ok(onlyMail);
    }

    /**
     * 查询所以信息
     * @return
     */
    @GetMapping("/all")
    public Result getAll(){
        Result result = onlyMailService.selectAll();
        return result;
    }

    /**
     * 修改
     * @param onlyMail
     * @return
     */
    @PostMapping("/update")
    public Result updateMail(@RequestBody OnlyMail onlyMail){
        Result result = onlyMailService.updateMail(onlyMail);
        return result;
    }


    @GetMapping("/send")
    public Result sendMail(Long id){
        Boolean mail = sendEmail.sendMail(id);
        return mail ? Result.ok("发送成功"):Result.fail("发送失败");
    }

}

