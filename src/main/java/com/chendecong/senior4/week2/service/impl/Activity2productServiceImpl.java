package com.chendecong.senior4.week2.service.impl;

import com.chendecong.senior4.week2.entity.Activity2product;
import com.chendecong.senior4.week2.mapper.Activity2productMapper;
import com.chendecong.senior4.week2.service.IActivity2productService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
@Service
public class Activity2productServiceImpl extends ServiceImpl<Activity2productMapper, Activity2product> implements IActivity2productService {

    @Autowired
    private Activity2productMapper activity2productMapper;

    @Override
    public Integer delByaid(Integer id) {
        return activity2productMapper.delByaid(id);
    }
}
