package com.payease.scfordermis.bo.requestBo;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ljp on 2018/1/9.
 */
public class GoodAddOrUpdateBo {
    @ApiModelProperty(value = "商品id（修改时必填，新增时可以为空）",dataType = "int")
    private Long goodsId;
    @ApiModelProperty(value = "商品名称",dataType = "string",required = true)
    private String goodsName;
    @ApiModelProperty(value = "商品分类id",dataType = "Long",required = true)
    private Long fCategoryId;
    /*@ApiModelProperty(value = "排序值",dataType = "string")
    private String fSort;*/
    @ApiModelProperty(value = "计量单位id",dataType = "Long",required = true)
    private Long fUnitId;
    /*@ApiModelProperty(value = "搜索关键字",dataType = "string",required = true)
    private String fSearchKey;*/
    @ApiModelProperty(value = "商品状态（上架-up，下架-down）",dataType = "string",required = true)
    private String fStatus;
    /*@ApiModelProperty(value = "商品标签(新品-新品，推荐-推荐，热卖-热卖)",dataType = "string")
    private String goodsLabel;*/
    @ApiModelProperty(value = "商品规格(格式：[{\n" +
            "\t\"picMain\": \"www.baidu.com\",\n" +
            "\t\"formatName\": \"优质\",\n" +
            "\t\"goodsNo\": \"0001\"，\n" +
            "\t\"goodsPrice \": \"1000.00”\n" +
            "}, {\n" +
            "\t\"picMain\": \"www.google.com\",\n" +
            "\t\"formatName\": \"普通\",\n" +
            "\t\"goodsNo\": \"0002\"，\n" +
            "\t\"goodsPrice \": \"2000.00”\n" +
            "}]",dataType = "string",required = true)
    private String formatJson;
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

    /*public List<ProductFormatBo> getFormatList() {
        return formatList;
    }

    public void setFormatList(List<ProductFormatBo> formatList) {
        this.formatList = formatList;
    }*/

    public String getFormatJson() {
        return formatJson;
    }

    public void setFormatJson(String formatJson) {
        this.formatJson = formatJson;
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
