package com.chendecong.senior4.week2.mapper;

import com.chendecong.senior4.week2.entity.Activity2product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
public interface Activity2productMapper extends BaseMapper<Activity2product> {

    Integer delByaid(Integer id);
}
