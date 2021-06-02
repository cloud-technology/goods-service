package com.example.demo.goods.interfaces.rest.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Goods object view Data Transfer Object
 */
@ApiModel(description = "Goods object view Data Transfer Object")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-30T16:54:09.001634+08:00[Asia/Taipei]")
public class GoodsViewDto extends RepresentationModel<GoodsViewDto>   {

  @JsonProperty("goodsId")
  private String goodsId;


  @JsonProperty("goodsName")
  private String goodsName;


  @JsonProperty("unitPrice")
  private Integer unitPrice;


  @JsonProperty("inventory")
  private Integer inventory;

  public GoodsViewDto goodsId(String goodsId) {
    this.goodsId = goodsId;
    return this;
  }

  /**
   * goods ID
   * @return goodsId
  */
  @ApiModelProperty(required = true, value = "goods ID")
  @NotNull


  public String getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(String goodsId) {
    this.goodsId = goodsId;
  }

  public GoodsViewDto goodsName(String goodsName) {
    this.goodsName = goodsName;
    return this;
  }

  /**
   * goods name
   * @return goodsName
  */
  @ApiModelProperty(required = true, value = "goods name")
  @NotNull


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public GoodsViewDto unitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  /**
   * unit price
   * @return unitPrice
  */
  @ApiModelProperty(required = true, value = "unit price")
  @NotNull


  public Integer getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }

  public GoodsViewDto inventory(Integer inventory) {
    this.inventory = inventory;
    return this;
  }

  /**
   * inventory
   * @return inventory
  */
  @ApiModelProperty(required = true, value = "inventory")
  @NotNull


  public Integer getInventory() {
    return inventory;
  }

  public void setInventory(Integer inventory) {
    this.inventory = inventory;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoodsViewDto goodsViewDto = (GoodsViewDto) o;
    return Objects.equals(this.goodsId, goodsViewDto.goodsId) &&
        Objects.equals(this.goodsName, goodsViewDto.goodsName) &&
        Objects.equals(this.unitPrice, goodsViewDto.unitPrice) &&
        Objects.equals(this.inventory, goodsViewDto.inventory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goodsId, goodsName, unitPrice, inventory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodsViewDto {\n");
    
    sb.append("    goodsId: ").append(toIndentedString(goodsId)).append("\n");
    sb.append("    goodsName: ").append(toIndentedString(goodsName)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    inventory: ").append(toIndentedString(inventory)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
