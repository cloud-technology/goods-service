package com.example.demo.goods.interfaces.transform;

import com.example.demo.goods.domain.model.entites.Goods;
import com.example.demo.goods.interfaces.rest.dto.GoodsViewDto;

import org.mapstruct.Mapper;

@Mapper
// @Mapper(componentModel = "spring")
public interface GoodsMapper {
    GoodsViewDto entityToDTO(Goods goods);
}
