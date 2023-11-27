package com.chenddd.mall.product.dao;

import com.chenddd.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chenddd
 * @email 2690541998@qq.com
 * @date 2022-10-16 20:49:08
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
