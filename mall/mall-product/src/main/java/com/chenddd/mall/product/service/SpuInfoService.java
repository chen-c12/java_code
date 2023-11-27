package com.chenddd.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenddd.common.utils.PageUtils;
import com.chenddd.mall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author chenddd
 * @email 2690541998@qq.com
 * @date 2022-10-16 20:49:07
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

