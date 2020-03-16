package com.chendecong.senior4.week2.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendecong.senior4.week2.entity.Activity;
import com.chendecong.senior4.week2.entity.Activity2product;
import com.chendecong.senior4.week2.entity.ActivityVo;
import com.chendecong.senior4.week2.entity.Product;
import com.chendecong.senior4.week2.service.IActivity2productService;
import com.chendecong.senior4.week2.service.IActivityService;
import com.chendecong.senior4.week2.service.IProductService;
import org.apache.kafka.common.metrics.stats.Total;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService iActivityService;

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IActivity2productService iActivity2productService;

    //列表方法
    @RequestMapping("/list")
    public String list(HttpServletRequest request, ActivityVo vo, @RequestParam(defaultValue = "1") long current,
                       @RequestParam(defaultValue = "3") long size) {
        System.out.println(vo.getEnddt()+""+vo.getBegindt());
        // 分页
        Page page = new Page(current, size);
        // 全部查询
        List<ActivityVo> vos = iActivityService.selectPageByVo(page, vo);
        for (int i = 0; i < vos.size(); i++) {
            System.out.println(vos.get(i).getBegindt() + "" + vos.get(i).getEnddt());
        }
        // 将数据发送到页面
        request.setAttribute("vo",vo);
        request.setAttribute("page", page);
        request.setAttribute("vos", vos);
        request.setAttribute("pages",page.getPages());
        return "active_list";
    }

    // 跳转到添加页面
    @RequestMapping("/toadd")
    public String toadd(HttpServletRequest request) {
        // 查询商品的列表
        List<Product> products = iProductService.list();
        request.setAttribute("products", products);
        return "active_add";
    }

    // 添加商品
    @RequestMapping("/add")
    public String add(Activity activity, Integer[] ids) {
        // 添加活动
        Integer id = iActivityService.addActivity(activity);
        // 添加商品对应的活动
        if (id > 0) {
            for (int i = 0; i < ids.length; i++) {
                Activity2product activity2product = new Activity2product();
                activity2product.setAid(activity.getId());
                activity2product.setPid(ids[i]);
                iActivity2productService.save(activity2product);
            }
        }

        return "redirect:list";
    }

    // 跳转到修改页面
    @RequestMapping("/toupdate")
    public String toUpdate(HttpServletRequest request, Integer id) {
        ActivityVo vo = iActivityService.selectByIds(id);
        List<Product> products = iProductService.list();
        String good_name = vo.getGood_name();
        String[] strings = good_name.split(",");
        ArrayList<String> goods = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            goods.add(strings[i]);
        }
        request.setAttribute("goods", goods);
        request.setAttribute("products", products);
        request.setAttribute("vo", vo);
        return "article_update";
    }

    // 进行修改
    @RequestMapping("/update")
    public String update(Activity activity,String s_total,Integer id, Integer[] ids) {
        activity.setTotal(Integer.parseInt(s_total.replace(",","")));
        boolean b = iActivityService.updateById(activity);
        // 讲中间表数据删除在添加
        if(b) {
            Integer i = iActivity2productService.delByaid(activity.getId());
            if(i>0) {
                for (int j = 0; j < ids.length; j++) {
                    Activity2product activity2product = new Activity2product();
                    activity2product.setAid(activity.getId());
                    activity2product.setPid(ids[j]);
                    iActivity2productService.save(activity2product);
                }
            }
        }
        return "redirect:list";
    }

    @RequestMapping("/torem")
    public String torem(Integer[] ids) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            nums.add(ids[i]);
        }
        boolean b = iActivityService.removeByIds(nums);
        if(b) {
            for (int i = 0; i < ids.length; i++) {
                iActivity2productService.delByaid(ids[i]);
            }
        }
        return "redirect:list";
    }

}

