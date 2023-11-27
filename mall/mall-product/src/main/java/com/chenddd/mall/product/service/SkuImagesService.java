package com.chenddd.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenddd.common.utils.PageUtils;
import com.chenddd.mall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author chenddd
 * @email 2690541998@qq.com
 * @date 2022-10-16 20:49:08
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

