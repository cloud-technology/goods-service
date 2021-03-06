/*
 * This file is generated by jOOQ.
 */
package com.example.demo.goods.domain.model.entites;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 商品資料
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Entity
@Table(
    name = "goods",
    schema = "testdb",
    uniqueConstraints = {
        @UniqueConstraint(name = "KEY_goods_PRIMARY", columnNames = { "goods_id" })
    }
)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    private String        goodsId;
    private String        goodsName;
    private Integer       unitPrice;
    private Integer       inventory;
    private Integer       version;
    private String        createdBy;
    private LocalDateTime createdDate;
    private String        lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public Goods() {}

    public Goods(Goods value) {
        this.goodsId = value.goodsId;
        this.goodsName = value.goodsName;
        this.unitPrice = value.unitPrice;
        this.inventory = value.inventory;
        this.version = value.version;
        this.createdBy = value.createdBy;
        this.createdDate = value.createdDate;
        this.lastModifiedBy = value.lastModifiedBy;
        this.lastModifiedDate = value.lastModifiedDate;
    }

    public Goods(
        String        goodsId,
        String        goodsName,
        Integer       unitPrice,
        Integer       inventory,
        Integer       version,
        String        createdBy,
        LocalDateTime createdDate,
        String        lastModifiedBy,
        LocalDateTime lastModifiedDate
    ) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
        this.version = version;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Getter for <code>testdb.goods.goods_id</code>. 商品編號
     */
    @Id
    @Column(name = "goods_id", nullable = false, length = 60)
    @NotNull
    @Size(max = 60)
    public String getGoodsId() {
        return this.goodsId;
    }

    /**
     * Setter for <code>testdb.goods.goods_id</code>. 商品編號
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * Getter for <code>testdb.goods.goods_name</code>. 商品名稱
     */
    @Column(name = "goods_name", nullable = false, length = 60)
    @NotNull
    @Size(max = 60)
    public String getGoodsName() {
        return this.goodsName;
    }

    /**
     * Setter for <code>testdb.goods.goods_name</code>. 商品名稱
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * Getter for <code>testdb.goods.unit_price</code>. 單價
     */
    @Column(name = "unit_price", nullable = false, precision = 10)
    @NotNull
    public Integer getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Setter for <code>testdb.goods.unit_price</code>. 單價
     */
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Getter for <code>testdb.goods.inventory</code>. 庫存數量
     */
    @Column(name = "inventory", nullable = false, precision = 10)
    @NotNull
    public Integer getInventory() {
        return this.inventory;
    }

    /**
     * Setter for <code>testdb.goods.inventory</code>. 庫存數量
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    /**
     * Getter for <code>testdb.goods.version</code>. 版本鎖
     */
    @Version
    @Column(name = "version", nullable = false, precision = 10)
    @NotNull
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Setter for <code>testdb.goods.version</code>. 版本鎖
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Getter for <code>testdb.goods.created_by</code>.
     */
    @Column(name = "created_by", nullable = false, length = 60)
    @NotNull
    @Size(max = 60)
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>testdb.goods.created_by</code>.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Getter for <code>testdb.goods.created_date</code>.
     */
    @Column(name = "created_date", nullable = false)
    @NotNull
    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    /**
     * Setter for <code>testdb.goods.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Getter for <code>testdb.goods.last_modified_by</code>.
     */
    @Column(name = "last_modified_by", nullable = false, length = 60)
    @NotNull
    @Size(max = 60)
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    /**
     * Setter for <code>testdb.goods.last_modified_by</code>.
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    /**
     * Getter for <code>testdb.goods.last_modified_date</code>.
     */
    @Column(name = "last_modified_date", nullable = false)
    @NotNull
    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * Setter for <code>testdb.goods.last_modified_date</code>.
     */
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
