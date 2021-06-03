/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.demo.goods.interfaces.rest;

import com.example.demo.goods.interfaces.rest.dto.ErrorMessage;
import com.example.demo.goods.interfaces.rest.dto.GoodsInventoryUpdateDto;
import com.example.demo.goods.interfaces.rest.dto.GoodsViewDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-06-03T12:03:01.654122+08:00[Asia/Taipei]")
@Validated
@Api(value = "Goods", description = "the Goods API", tags={ "Goods" })
public interface GoodsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /goods : Your GET endpoint
     * 取得商品清單
     *
     * @return OK (status code 200)
     */
    @ApiOperation(value = "Your GET endpoint", nickname = "getGoods", notes = "取得商品清單", response = GoodsViewDto.class, responseContainer = "List", authorizations = {
        
        @Authorization(value = "JWT")
         }, tags={ "Goods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GoodsViewDto.class, responseContainer = "List") })
    @GetMapping(
        value = "/goods",
        produces = "application/json"
    )
    default ResponseEntity<List<GoodsViewDto>> getGoods() throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 0, \"goodsId\" : \"goodsId\", \"inventory\" : 6, \"goodsName\" : \"goodsName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /goods/{goodsId} : get goods by ID
     * 取得單一商品
     *
     * @param goodsId 商品ID (required)
     * @return OK (status code 200)
     *         or 錯誤通用回覆 (status code 404)
     */
    @ApiOperation(value = "get goods by ID", nickname = "getGoodsGoodsId", notes = "取得單一商品", response = GoodsViewDto.class, authorizations = {
        
        @Authorization(value = "JWT")
         }, tags={ "Goods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GoodsViewDto.class),
        @ApiResponse(code = 404, message = "錯誤通用回覆", response = ErrorMessage.class) })
    @GetMapping(
        value = "/goods/{goodsId}",
        produces = "application/json"
    )
    default ResponseEntity<GoodsViewDto> getGoodsGoodsId(@ApiParam(value = "商品ID",required=true) @PathVariable("goodsId") String goodsId) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 0, \"goodsId\" : \"goodsId\", \"inventory\" : 6, \"goodsName\" : \"goodsName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /goods/{goodsId}/inventory : Update goods inventory
     * 更新單一商品庫存
     *
     * @param goodsId 商品ID (required)
     * @param goodsInventoryUpdateDto  (optional)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "Update goods inventory", nickname = "patchGoodsGoodsIdInventory", notes = "更新單一商品庫存", response = GoodsViewDto.class, authorizations = {
        
        @Authorization(value = "JWT")
         }, tags={ "Goods", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = GoodsViewDto.class) })
    @PatchMapping(
        value = "/goods/{goodsId}/inventory",
        produces = "application/json",
        consumes = "application/json"
    )
    default ResponseEntity<GoodsViewDto> patchGoodsGoodsIdInventory(@ApiParam(value = "商品ID",required=true) @PathVariable("goodsId") String goodsId,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) GoodsInventoryUpdateDto goodsInventoryUpdateDto) throws Exception {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unitPrice\" : 0, \"goodsId\" : \"goodsId\", \"inventory\" : 6, \"goodsName\" : \"goodsName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
