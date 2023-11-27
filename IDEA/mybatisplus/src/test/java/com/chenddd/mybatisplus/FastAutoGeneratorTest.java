package com.chenddd.mybatisplus;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;


/**
* Author: chenddd
* Date: 2022/4/7 10:55
* FileName: FastAutoGeneratorTest
* Description: 
*/
public class FastAutoGeneratorTest {
    @Test
    public void test(){
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis_plus? characterEncoding=utf-8&userSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("chenddd") // 设置作者
                                    //.enableSwagger() // 开启 swagger 模式
                                    .fileOverride() // 覆盖已生成文件
                                    .outputDir("D://cache"); // 指定输出目录
                        })
                        .packageConfig(builder -> {
                            builder.parent("com.chenddd") // 设置父包名
                                    .moduleName("mybatisplus") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.xml,"D://cache"));// 设置mapperXml生成路径
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("user") // 设置需要生成的表名
                                    .addTablePrefix("t_","c_"); // 设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine())
                        // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .execute();
    }
}
