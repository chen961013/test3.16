package com.chendecong.senior4.week2;

import com.chendecong.senior4.week2.entity.Activity;
import com.chendecong.senior4.week2.entity.Activity2product;
import com.chendecong.senior4.week2.entity.ActivityVo;
import com.chendecong.senior4.week2.entity.Product;
import com.chendecong.senior4.week2.service.IActivity2productService;
import com.chendecong.senior4.week2.service.IActivityService;
import com.chendecong.senior4.week2.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExTest {
    @Autowired
    private IActivity2productService iActivity2productService;

    @Autowired
    private IActivityService iActivityService;

    @Autowired
    private IProductService iProductService;

    @Test
    public void test1() {
        List<Product> list = iProductService.list();
        System.out.println(list);
    }

    @Test
    public void test2() {
        List<Activity> list = iActivityService.list();
        System.out.println(list);
    }

    @Test
    public void test3() {
        List<Activity2product> list = iActivity2productService.list();
        System.out.println(list);
    }

    @Test
    public void test4() {
        ActivityVo activityVo = iActivityService.selectByIds(1);
        System.out.println(activityVo);
    }

    @Test
    public void test5() {
        List<Product> list = iProductService.list();
        System.out.println(list);
    }
}
