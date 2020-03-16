package com.chendecong.senior4.week2.service.impl;

import com.chendecong.senior4.week2.entity.Product;
import com.chendecong.senior4.week2.mapper.ProductMapper;
import com.chendecong.senior4.week2.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdc
 * @since 2020-03-02
 */
@Service
@Transactional(transactionManager = "transactionManager")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
