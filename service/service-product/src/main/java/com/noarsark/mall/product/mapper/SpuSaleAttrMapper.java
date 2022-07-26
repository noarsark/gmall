package com.noarsark.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noarsark.mall.model.product.SpuSaleAttr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author noarsark
 * @date 2022/8/7
 * @apiNote
 */
@Mapper
public interface SpuSaleAttrMapper extends BaseMapper<SpuSaleAttr> {
    List<SpuSaleAttr> selectSpuSaleAttrList(Long spuId);
}
