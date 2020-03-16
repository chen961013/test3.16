package com.chendecong.senior4.week2.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendecong.senior4.week2.entity.Activity;
import com.chendecong.senior4.week2.entity.Activity2product;
import com.chendecong.senior4.week2.entity.ActivityVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
public interface IActivityService extends IService<Activity> {

    List<ActivityVo> selectPageByVo(Page page, ActivityVo vo);

    Integer addActivity(Activity activity);

    ActivityVo selectByIds(Integer id);
}
