package com.noarsark.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.noarsark.mall.common.result.Result;
import com.noarsark.mall.model.product.SkuInfo;
import com.noarsark.mall.product.service.ManageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author noarsark
 * @date 2022/8/8
 * @apiNote
 */
@Api(tags = "商品SKU接口")
@RestController
@RequestMapping("admin/product")
public class SkuManagerController {
    @Autowired
    private ManageService manageService;

    //  http://api.gmall.com/admin/product/saveSkuInfo
    //  获取到前端传递过来的数据！   Json --> JavaObject
    @PostMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo){
        //  调用服务层方法
        manageService.saveSkuInfo(skuInfo);
        //  返回
        return Result.ok();
    }

    //  http://api.gmall.com/admin/product/list/{page}/{limit}
    @GetMapping("list/{page}/{limit}")
    public Result getSkuInfoList(@PathVariable Long page,
                                 @PathVariable Long limit){
        //  创建一个Page 对象
        Page<SkuInfo> skuInfoPage = new Page<>(page,limit);

        //  调用服务层方法
        IPage iPage = manageService.getSkuInfoList(skuInfoPage);

        return Result.ok(iPage);
    }

    //  http://api.gmall.com/admin/product/onSale/{skuId}
    @GetMapping("onSale/{skuId}")
    public Result onSale(@PathVariable Long skuId){
        //  调用服务层方法
        manageService.onSale(skuId);
        //  返回数据
        return Result.ok();
    }

    //  http://api.gmall.com/admin/product/cancelSale/{skuId}
    @GetMapping("cancelSale/{skuId}")
    public Result cancelSale(@PathVariable Long skuId){
        //  调用服务层方法
        manageService.cancelSale(skuId);
        //  返回数据
        return Result.ok();
    }


}
