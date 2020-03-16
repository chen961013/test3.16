package com.chendecong.senior4.week2.service;

import com.chendecong.senior4.week2.entity.Activity2product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
public interface IActivity2productService extends IService<Activity2product> {

    Integer delByaid(Integer id);
}
