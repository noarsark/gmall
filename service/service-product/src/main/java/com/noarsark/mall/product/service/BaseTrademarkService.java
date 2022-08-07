package com.noarsark.mall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.noarsark.mall.model.product.BaseTrademark;

/**
 * @author noarsark
 * @date 2022/7/23
 * @apiNote
 */
public interface BaseTrademarkService extends IService<BaseTrademark> {

    /**
     * 分页列表
     * @param pageParam
     * @return
     */
    IPage<BaseTrademark> getPage(Page<BaseTrademark> pageParam);
}
