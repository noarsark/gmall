package com.noarsark.mall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.noarsark.mall.common.result.Result;
import com.noarsark.mall.model.product.BaseSaleAttr;
import com.noarsark.mall.model.product.SpuImage;
import com.noarsark.mall.model.product.SpuInfo;
import com.noarsark.mall.model.product.SpuSaleAttr;
import com.noarsark.mall.product.service.ManageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author noarsark
 * @date 2022/7/22
 * @apiNote
 */
@Api(tags = "商品属性SPU接口")
@RestController
@RequestMapping("admin/product")
public class SpuManageController {

    @Autowired
    private ManageService manageService;

    // 根据查询条件封装控制器
    // springMVC 的时候，有个叫对象属性传值 如果页面提交过来的参数与实体类的参数一致，
    // 则可以使用实体类来接收数据
    // http://api.gmall.com/admin/product/1/10?category3Id=61
    // @RequestBody 作用 将前台传递过来的json{"category3Id":"61"}  字符串变为java 对象。

    @GetMapping("{page}/{size}")
    public Result getSpuInfoPage(@PathVariable Long page,
                                 @PathVariable Long size,
                                 SpuInfo spuInfo) {
        Page<SpuInfo> spuInfoPage = new Page<>(page, size);
        // 获取数据
        IPage<SpuInfo> spuInfoPageList = manageService.getSpuInfoPage(spuInfoPage, spuInfo);
        // 将获取到的数据返回
        return Result.ok(spuInfoPageList);
    }


    /**
     * 销售属性http://api.gmall.com/admin/product/baseSaleAttrList
     * @return
     */
    @GetMapping("baseSaleAttrList")
    public Result baseSaleAttrList(){
        // 查询所有的销售属性集合
        List<BaseSaleAttr> baseSaleAttrList = manageService.getBaseSaleAttrList();

        return Result.ok(baseSaleAttrList);
    }

    //  http://api.gmall.com/admin/product/saveSpuInfo
    //  获取到前端传递过来的数据 Json ---> JavaObject
    @PostMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){
        //  调用服务层方法
        manageService.saveSpuInfo(spuInfo);
        //  返回
        return Result.ok();
    }

    //  http://api.gmall.com/admin/product/spuImageList/29
    @GetMapping("spuImageList/{spuId}")
    public Result getSpuImageList(@PathVariable Long spuId){
        //  调用服务层方法
        List<SpuImage> spuImageList = manageService.getSpuImageList(spuId);
        return Result.ok(spuImageList);
    }

    //  http://api.gmall.com/admin/product/spuSaleAttrList/29
    @GetMapping("spuSaleAttrList/{spuId}")
    public Result getSpuSaleAttrList(@PathVariable Long spuId){
        // 调用服务层方法
         List<SpuSaleAttr> spuSaleAttrList = manageService.getSpuSaleAttrList(spuId);
         return Result.ok(spuSaleAttrList);
    }


}
