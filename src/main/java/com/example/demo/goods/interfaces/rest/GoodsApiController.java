package com.example.demo.goods.interfaces.rest;

import com.example.demo.goods.application.services.GoodsService;
import com.example.demo.goods.interfaces.rest.dto.GoodsInventoryUpdateDto;
import com.example.demo.goods.interfaces.rest.dto.GoodsViewDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-27T17:51:43.377335+08:00[Asia/Taipei]")
@RestController
@RequestMapping("${openapi.goods.base-path:}")
@RequiredArgsConstructor
public class GoodsApiController implements GoodsApi {

    private final GoodsService goodsService;

    public ResponseEntity<GoodsViewDto> getGoodsGoodsId(String goodsId) throws Exception {
        return new ResponseEntity<GoodsViewDto>(goodsService.findById(goodsId), HttpStatus.OK);
    }

    public ResponseEntity<GoodsViewDto> patchGoodsGoodsIdInventory(String goodsId,
            GoodsInventoryUpdateDto goodsInventoryUpdateDto) throws Exception {
        return new ResponseEntity<GoodsViewDto>(goodsService.patchGoodsInventory(goodsId, goodsInventoryUpdateDto),
                HttpStatus.OK);
    }
}
