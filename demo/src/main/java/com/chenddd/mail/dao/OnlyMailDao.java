package com.chenddd.mail.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.chenddd.mail.entity.OnlyMail;

/**
 * (OnlyMail)表数据库访问层
 *
 * @author chenddd
 * @since 2022-11-07 11:43:31
 */
public interface OnlyMailDao extends BaseMapper<OnlyMail> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<OnlyMail> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<OnlyMail> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<OnlyMail> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<OnlyMail> entities);

}

