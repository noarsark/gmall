package com.noarsark.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noarsark.mall.model.product.BaseTrademark;
import com.noarsark.mall.product.mapper.BaseTrademarkMapper;
import com.noarsark.mall.product.service.BaseTrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author noarsark
 * @date 2022/7/23
 * @apiNote
 */
@Service
public class BaseTrademarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark> implements BaseTrademarkService {

    @Autowired
    BaseTrademarkMapper baseTrademarkMapper;


    @Override
    public IPage<BaseTrademark> getPage(Page<BaseTrademark> pageParam) {
        QueryWrapper<BaseTrademark> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");

        IPage<BaseTrademark> page = baseTrademarkMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}
