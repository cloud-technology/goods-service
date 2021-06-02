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
 * 商品庫存更新
 */
@ApiModel(description = "商品庫存更新")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-30T16:54:09.001634+08:00[Asia/Taipei]")
public class GoodsInventoryUpdateDto extends RepresentationModel<GoodsInventoryUpdateDto>   {

  @JsonProperty("inventory")
  private Integer inventory;

  public GoodsInventoryUpdateDto inventory(Integer inventory) {
    this.inventory = inventory;
    return this;
  }

  /**
   * 庫存數量
   * minimum: 0
   * @return inventory
  */
  @ApiModelProperty(required = true, value = "庫存數量")
  @NotNull

@Min(0)
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
    GoodsInventoryUpdateDto goodsInventoryUpdateDto = (GoodsInventoryUpdateDto) o;
    return Objects.equals(this.inventory, goodsInventoryUpdateDto.inventory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inventory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodsInventoryUpdateDto {\n");
    
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
