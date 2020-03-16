package com.chendecong.senior4.week2.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendecong.senior4.week2.entity.Activity;
import com.chendecong.senior4.week2.entity.Activity2product;
import com.chendecong.senior4.week2.entity.ActivityVo;
import com.chendecong.senior4.week2.mapper.ActivityMapper;
import com.chendecong.senior4.week2.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
@Service

public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<ActivityVo> selectPageByVo(Page page, ActivityVo vo) {
        return activityMapper.selectPageByVo(page,vo);
    }

    @Override
    public Integer addActivity(Activity activity) {
        return activityMapper.addActivity(activity);
    }

    @Override
    public ActivityVo selectByIds(Integer id) {
        return activityMapper.selectByIds(id);
    }
}
