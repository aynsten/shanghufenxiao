package com.payease.scfordermis.bo.responseBo;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by ljp on 2018/1/9.
 */
public class GoodUpdateShowBo {
    @ApiModelProperty(value = "商品id",dataType = "int")
    private Long goodsId;
    @ApiModelProperty(value = "商品名称",dataType = "string")
    private String goodsName;
    @ApiModelProperty(value = "商品分类id",dataType = "string")
    private Long fCategoryId;
    @ApiModelProperty(value = "商品分类名称",dataType = "string")
    private String fCategoryName;
    /*@ApiModelProperty(value = "排序值",dataType = "string")
    private String fSort;*/
    @ApiModelProperty(value = "计量单位id",dataType = "string")
    private Long fUnitId;
    @ApiModelProperty(value = "计量单位name",dataType = "string")
    private String fUnitName;
    /*@ApiModelProperty(value = "搜索关键字",dataType = "string")
    private String fSearchKey;*/
    @ApiModelProperty(value = "商品状态",dataType = "string")
    private String fStatus;
    /*@ApiModelProperty(value = "商品标签",dataType = "string")
    private String goodsLabel;*/
    @ApiModelProperty(value = "商品规格",dataType = "string",required = true)
    private List<ProductFormatBo> formatList;
    /*@ApiModelProperty(value = "商品图片",dataType = "string")
    private String fPicList;*/
    @ApiModelProperty(value = "商品描述",dataType = "string")
    private String fDesp;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getfCategoryId() {
        return fCategoryId;
    }

    public void setfCategoryId(Long fCategoryId) {
        this.fCategoryId = fCategoryId;
    }

    public String getfCategoryName() {
        return fCategoryName;
    }

    public void setfCategoryName(String fCategoryName) {
        this.fCategoryName = fCategoryName;
    }

    /*public String getfSort() {
        return fSort;
    }

    public void setfSort(String fSort) {
        this.fSort = fSort;
    }*/

    public Long getfUnitId() {
        return fUnitId;
    }

    public void setfUnitId(Long fUnitId) {
        this.fUnitId = fUnitId;
    }

    public String getfUnitName() {
        return fUnitName;
    }

    public void setfUnitName(String fUnitName) {
        this.fUnitName = fUnitName;
    }
    /*public String getfSearchKey() {
        return fSearchKey;
    }

    public void setfSearchKey(String fSearchKey) {
        this.fSearchKey = fSearchKey;
    }*/

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    /*public String getGoodsLabel() {
        return goodsLabel;
    }

    public void setGoodsLabel(String goodsLabel) {
        this.goodsLabel = goodsLabel;
    }*/

    public List<ProductFormatBo> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<ProductFormatBo> formatList) {
        this.formatList = formatList;
    }
    /*public String getfPicList() {
        return fPicList;
    }

    public void setfPicList(String fPicList) {
        this.fPicList = fPicList;
    }*/

    public String getfDesp() {
        return fDesp;
    }

    public void setfDesp(String fDesp) {
        this.fDesp = fDesp;
    }
}
