package com.chenddd.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenddd.mybatisplus.mapper.ProductMapper;
import com.chenddd.mybatisplus.pojo.Product;
import com.chenddd.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
* Author: chenddd
* Date: 2022/4/7 14:44
* FileName: ProductServiceImpl
* Description: 
*/
@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
