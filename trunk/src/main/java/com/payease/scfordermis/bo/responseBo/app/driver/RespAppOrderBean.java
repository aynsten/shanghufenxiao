package com.payease.scfordermis.bo.responseBo.app.driver;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zhangzhili on 2018/1/11.
 */
@ApiModel("订单列表实体类")
public class RespAppOrderBean {

    @ApiModelProperty(value = "订单id", dataType = "long")
    private long orderId;
    @ApiModelProperty(value = "订单号")
    private String orderNum;
    @ApiModelProperty(value = "客户名字")
    private String customerName;
    @ApiModelProperty(value = "商品种类", dataType = "integer")
    private int productCategoryNum;
    @ApiModelProperty(value = "商品总数", dataType = "integer")
    private int productNum;
    @ApiModelProperty(value = "订单状态")
    private String status;
    @ApiModelProperty(value = "车牌号")
    private String cardNum;
    @ApiModelProperty(value = "司机名字")
    private String driverName;
    @ApiModelProperty(value = "司机手机号")
    private String driverPhone;
    @ApiModelProperty(value = "提货码")
    private String pickUpCode;


    private List<RespAppGoodBean> goodBeanList;


    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getPickUpCode() {
        return pickUpCode;
    }

    public void setPickUpCode(String pickUpCode) {
        this.pickUpCode = pickUpCode;
    }

    public List<RespAppGoodBean> getGoodBeanList() {
        return goodBeanList;
    }

    public void setGoodBeanList(List<RespAppGoodBean> goodBeanList) {
        this.goodBeanList = goodBeanList;
    }



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getProductCategoryNum() {
        return productCategoryNum;
    }

    public void setProductCategoryNum(int productCategoryNum) {
        this.productCategoryNum = productCategoryNum;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
