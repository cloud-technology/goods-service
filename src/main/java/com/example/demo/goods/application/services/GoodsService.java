package com.example.demo.goods.application.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.goods.domain.model.entites.Goods;
import com.example.demo.goods.infrastructure.repositories.GoodsRepository;
import com.example.demo.goods.interfaces.rest.dto.GoodsInventoryUpdateDto;
import com.example.demo.goods.interfaces.rest.dto.GoodsViewDto;
import com.example.demo.goods.interfaces.transform.GoodsMapper;

import org.mapstruct.factory.Mappers;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    // private final GoodsMapper goodsMapper;

    public List<GoodsViewDto> findAll() {
        List<Goods> goodsList = goodsRepository.findAll();
        GoodsMapper goodsMapper = Mappers.getMapper(GoodsMapper.class);
        List<GoodsViewDto> GoodsViewDtoList = goodsList.stream().map(goods -> goodsMapper.entityToDTO(goods)).collect(Collectors.toList());
        return GoodsViewDtoList;
    }

    public GoodsViewDto findById(String goodsId) {
        Optional<Goods> optionalGoods = goodsRepository.findById(goodsId);
        optionalGoods.orElseThrow(ResourceNotFoundException::new);
        GoodsMapper goodsMapper = Mappers.getMapper(GoodsMapper.class);
        GoodsViewDto goodsViewDto = goodsMapper.entityToDTO(optionalGoods.get());
        return goodsViewDto;
    }

    public GoodsViewDto patchGoodsInventory(String goodsId, GoodsInventoryUpdateDto goodsInventoryUpdateDto) {
        Optional<Goods> optionalGoods = goodsRepository.findById(goodsId);
        optionalGoods.orElseThrow(ResourceNotFoundException::new);
        Goods goods = optionalGoods.get();
        goods.setInventory(goodsInventoryUpdateDto.getInventory());
        goods = goodsRepository.save(goods);
        GoodsMapper goodsMapper = Mappers.getMapper(GoodsMapper.class);
        GoodsViewDto goodsViewDto = goodsMapper.entityToDTO(goods);
        return goodsViewDto;
    }

}
