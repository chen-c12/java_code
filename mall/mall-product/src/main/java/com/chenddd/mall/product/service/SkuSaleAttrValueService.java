package com.chenddd.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenddd.common.utils.PageUtils;
import com.chenddd.mall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author chenddd
 * @email 2690541998@qq.com
 * @date 2022-10-16 20:49:07
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

