package com.chendecong.senior4.week2.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendecong.senior4.week2.entity.Activity;
import com.chendecong.senior4.week2.entity.Activity2product;
import com.chendecong.senior4.week2.entity.ActivityVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    List<ActivityVo> selectPageByVo(Page page, ActivityVo vo);

    Integer addActivity(@RequestParam("activity") Activity activity);

    ActivityVo selectByIds(Integer id);
}
