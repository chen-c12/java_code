package com.chenddd.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
* Author: chenddd
* Date: 2022/4/6 20:17
* FileName: Product
* Description: 
*/
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version    //标识乐观锁版本号字段
    private Integer version;
}
