package com.payease.scfordermis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.payease.scfordermis.bean.PageRequest;
import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.bo.requestBo.GoodAddOrUpdateBo;
import com.payease.scfordermis.bo.responseBo.*;
import com.payease.scfordermis.bo.ResultBo;
import com.payease.scfordermis.dao.*;
import com.payease.scfordermis.entity.TCategoryInfoEntity;
import com.payease.scfordermis.entity.TProductFormatEntity;
import com.payease.scfordermis.entity.TProductInfoEntity;
import com.payease.scfordermis.entity.TUnitInfoEntity;
import com.payease.scfordermis.exception.CommonRuntimeException;
import com.payease.scfordermis.service.IGoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by ljp on 2018/1/10.
 */
@Service

public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    CategoryInfoDao categoryInfoDao;
    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    UnitInfoDao unitInfoDao;
    @Autowired
    ProductFormatDao productFormatDao;
    @Autowired
    TransportOrderDetailDao transportOrderDetailDao;

    @Override
    public ResultBo categoryAddOrUpdate(Long id, String categoryName, Long categoryParentId, RespLoginPCBean respLoginPCBean) {
        ResultBo result = ResultBo.build();
        String level;
        if (categoryParentId == 0) {
            level = "1";
        } else {
            level = "2";
        }
        TCategoryInfoEntity tCategoryInfoEntity = new TCategoryInfoEntity();
        //从Session中获取f_company_id
        tCategoryInfoEntity.setfCompanyId(respLoginPCBean.getfCompanyId());
        //从Session中获取操作人的id
        tCategoryInfoEntity.setfOperate(respLoginPCBean.getfId());
        tCategoryInfoEntity.setfLevel(level);
        tCategoryInfoEntity.setfName(categoryName);
        tCategoryInfoEntity.setfParentId(categoryParentId);
        //编辑（新增没有id）
        if (null != id) {
            TCategoryInfoEntity byFNameAndFCompanyId = categoryInfoDao.findByFNameAndFCompanyId(categoryName,respLoginPCBean.getfCompanyId());
            if (byFNameAndFCompanyId != null) {
                if (id.longValue() != byFNameAndFCompanyId.getfId()) {
                    throw new CommonRuntimeException(Status.GOODSCATEREPEAT);
                }
            }
            tCategoryInfoEntity.setfUpdateTime(new Date());
            Date createTime = categoryInfoDao.findOne(id).getfCreateTime();
            tCategoryInfoEntity.setfCreateTime(createTime);
            tCategoryInfoEntity.setfId(id);
            categoryInfoDao.save(tCategoryInfoEntity);
        } else {                                             //新增
            Long aLong = categoryInfoDao.countTCategoryInfoEntitiesByFNameAndFCompanyId(categoryName, respLoginPCBean.getfCompanyId());
            //判断分类名称是否重复
            if (aLong > 0) {
                return result.setCodeId(Status.GOODSCATEREPEAT);
            }
            tCategoryInfoEntity.setfCreateTime(new Date());
            tCategoryInfoEntity.setfUpdateTime(new Date());
            TCategoryInfoEntity save = categoryInfoDao.save(tCategoryInfoEntity);
            // 注意：若该一级节点下已有商品，在该一级节点添加子节点时，需要将原有一级节点的商品全部移动到新增的二级节点下
            if ("2".equals(level)) {
                List<TProductInfoEntity> list = productInfoDao.findByFCompanyIdAndFCategoryIdOneAndFCategoryIdTwo(respLoginPCBean.getfCompanyId(), categoryParentId, 0L);
                if (!list.isEmpty()) {
                    for (TProductInfoEntity productInfoEntity : list) {
                        productInfoEntity.setfCategoryIdTwo(save.getfId());
                        productInfoDao.save(productInfoEntity);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public ResultBo categoryDelete(Long id) {
        ResultBo result = ResultBo.build();
        //判断商品分类下是否有商品
        TCategoryInfoEntity one = categoryInfoDao.findOne(id);
        if ("1".equals(one.getfLevel())) {
            Long oLong = productInfoDao.countTProductInfoEntitiesByFCategoryIdOneEquals(id);
            if (oLong > 0) {
                return result.setCodeId(Status.GOODSCATEFAIL);
            } else {
                categoryInfoDao.delete(id);
                return result;
            }
        } else {
            Long tLong = productInfoDao.countTProductInfoEntitiesByFCategoryIdTwoEquals(id);
            if (tLong > 0) {
                return result.setCodeId(Status.GOODSCATEFAIL);
            } else {
                categoryInfoDao.delete(id);
                return result;
            }
        }
    }

    @Override
    public List<QueryCategoryBo> getCategoryList(Long companyId) {
        List<QueryCategoryBo> list = new ArrayList<>();
        //把所有一级菜单查询来
        List<TCategoryInfoEntity> byFLevel = categoryInfoDao.findByFLevelAndFCompanyIdOrderByFUpdateTimeDesc("1", companyId);
        if (!byFLevel.isEmpty()){
            for (int i = 0; i < byFLevel.size(); i++) {
                //通过id 找到所属这个一级菜单的二级菜单
                List<TCategoryInfoEntity> byFParentIdList = categoryInfoDao.findByFParentIdOrderByFUpdateTimeDesc(byFLevel.get(i).getfId());
                QueryCategoryBo queryCategoryBo = new QueryCategoryBo();
                queryCategoryBo.setfId(byFLevel.get(i).getfId());
                queryCategoryBo.setfName(byFLevel.get(i).getfName());
                queryCategoryBo.setChildList(byFParentIdList);
                list.add(queryCategoryBo);
            }
        }
        return list;
    }

    @Override
    public ResultBo unitAdd(String unitName, RespLoginPCBean respLoginPCBean) {
        ResultBo result = ResultBo.build();
        //新增时判断计量单位名称是否重复
        //companyId 从session中获取
        Long companyId = respLoginPCBean.getfCompanyId();
        Long aLong = unitInfoDao.countByFNameAndFCompanyId(unitName, companyId);
        if (aLong > 0) {
            return result.setCodeId(Status.GOODUNITREOEAT);
        }
        TUnitInfoEntity tUnitInfoEntity = new TUnitInfoEntity();
        //从session 中获取
        tUnitInfoEntity.setfCompanyId(companyId);
        tUnitInfoEntity.setfCreateTime(new Date());
        tUnitInfoEntity.setfUpdateTime(new Date());
        tUnitInfoEntity.setfName(unitName);
        //从Session中获取
        tUnitInfoEntity.setfOperate(respLoginPCBean.getfId());
        tUnitInfoEntity.setfUpdateTime(new Date());
        unitInfoDao.save(tUnitInfoEntity);
        return result;
    }

    @Override
    public ResultBo unitDelete(Long id) {
        //已有商品使用该计量单位，不能删除
        ResultBo result = ResultBo.build();
        Long aLong = productInfoDao.countTProductInfoEntitiesByFUnitId(id);
        if (aLong > 0) {
            return result.setCodeId(Status.GOODUNITFAIL);
        }
        //已有运单使用该计量单位，不能删除
        Long aLong1 = transportOrderDetailDao.countByTUnitInfoId(id);
        if (aLong1 > 0){
            return result.setCodeId(Status.TRANSPORTFAIL);
        }
        unitInfoDao.delete(id);
        return result;
    }

    @Override
    public ResultBo unitList(Long companyId) {
        ResultBo result = ResultBo.build();
//        Long companyId = 1L;//通过session 获取companyId
        List<TUnitInfoEntity> byFCompanyIdEquals = unitInfoDao.findByFCompanyIdEqualsOrderByFCreateTimeDesc(companyId);
        List<UnitBo> unitBoList = new ArrayList<>();
        if (!byFCompanyIdEquals.isEmpty()){
            for (int i = 0; i < byFCompanyIdEquals.size(); i++) {
                UnitBo unitBo = new UnitBo();
                unitBo.setfId(byFCompanyIdEquals.get(i).getfId());
                unitBo.setfName(byFCompanyIdEquals.get(i).getfName());
                unitBoList.add(unitBo);
            }
        }
        result.setResultBody(unitBoList);
        return result;
    }

    @Override
    public Page<GoodsManageBo> getGoodsList(Long categoryId,String searchCondition, Integer page, Integer size, RespLoginPCBean respLoginPCBean) {
        //根据categoryId可以查出level,所以不用前台传level
        Sort sort = new Sort(Sort.Direction.DESC, "fCreateTime");
        //根据条件查询订单
        Specification<TProductInfoEntity> category1 = (root, query, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<Predicate>();
            if (null != categoryId) {
                TCategoryInfoEntity one = categoryInfoDao.findOne(categoryId);
                String level = one.getfLevel();
                if ("1".equals(level)) {
                    list.add(criteriaBuilder.equal(root.get("fCategoryIdOne").as(Integer.class), categoryId));
                } else {
                    list.add(criteriaBuilder.equal(root.get("fCategoryIdTwo").as(Integer.class), categoryId));
                }
            }
            if (StringUtils.isNotBlank(searchCondition)) {
                list.add(criteriaBuilder.like(root.get("fSearchCondition").as(String.class), "%" + searchCondition + "%"));
            }
            //从session 中获取companyId
            list.add(criteriaBuilder.equal(root.get("fCompanyId").as(Integer.class), respLoginPCBean.getfCompanyId()));
            Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        };
        Page<TProductInfoEntity> tProductInfoEntityPage = productInfoDao.findAll(category1, PageRequest.of(page, size, sort));
        List<GoodsManageBo> list = new ArrayList<>();
        for (TProductInfoEntity tProductInfoEntity : tProductInfoEntityPage.getContent()) {
            GoodsManageBo goodsManageBo = new GoodsManageBo();
            //商品id
            goodsManageBo.setGoodsId(tProductInfoEntity.getfId());
//            goodsManageBo.setPicAll(tProductInfoEntity.getfPicList());      //水果图片集合
            //商品名称
            goodsManageBo.setGoodsName(tProductInfoEntity.getfName());
            //商品编码
//            goodsManageBo.setGoodsNo(tProductInfoEntity.getfCode());
            //状态
            goodsManageBo.setStatus(tProductInfoEntity.getfStatus());

            //首先判断二级分类，如果为0，就显示一级分类的名称。如果不为0，就显示二级分类的名称
            long l = tProductInfoEntity.getfCategoryIdTwo();
            if (l == 0) {
                //分类名称
                goodsManageBo.setCategoryName(categoryInfoDao.findOne(tProductInfoEntity.getfCategoryIdOne()).getfName());
            } else {
                //分类名称
                goodsManageBo.setCategoryName(categoryInfoDao.findOne(l).getfName());
            }
            //从session 中获取companyId
            List<TProductFormatEntity> byFProductId = productFormatDao.findByFProductIdAndFCompanyIdOrderByFPriceAsc(tProductInfoEntity.getfId(), respLoginPCBean.getfCompanyId());
            if (null != byFProductId.get(0).getfPic()){
                //列表中主图，选择规格中的第一个。
                goodsManageBo.setPicMain(byFProductId.get(0).getfPic());
            }
            String format = "";
            for (int i = 0; i < byFProductId.size(); i++) {
                String s = byFProductId.get(i).getfName();
                if (i != byFProductId.size() - 1) {
                    format += s + ",";
                } else {
                    format += s;
                }
            }
            //规格
            goodsManageBo.setFormatName(format);
            //销售价
            goodsManageBo.setPrice(byFProductId.get(0).getfPrice());
            //单位
            goodsManageBo.setUnitName(unitInfoDao.findOne(tProductInfoEntity.getfUnitId()).getfName());
//            goodsManageBo.setLabel();                                       //商品标签
            list.add(goodsManageBo);
        }
        Page<GoodsManageBo> goodsManageBos = new PageImpl<GoodsManageBo>(list, PageRequest.of(page, size, sort), tProductInfoEntityPage.getTotalElements());
        return goodsManageBos;
    }
    /**
     *  修改/详情商品接口
     */
    @Override
    public GoodUpdateShowBo getGoodsMessage(Long goodId) {
        //通过商品id查出商品规格信息
        List<TProductFormatEntity> tProductFormatEntityList = productFormatDao.findByFProductId(goodId);
        //把实体类的属性拷贝到bo类
        List<ProductFormatBo> newList = new ArrayList<>();
        for (TProductFormatEntity tProductFormatEntity : tProductFormatEntityList) {
            ProductFormatBo productFormatBo = new ProductFormatBo();
            productFormatBo.setFormatId(tProductFormatEntity.getfId());
            productFormatBo.setFormatName(tProductFormatEntity.getfName());
            productFormatBo.setGoodsNo(tProductFormatEntity.getfCode());
            productFormatBo.setGoodsPrice(tProductFormatEntity.getfPrice());
            productFormatBo.setPicMain(tProductFormatEntity.getfPic());
            newList.add(productFormatBo);
        }
        //通过商品id查出商品信息
        TProductInfoEntity one = productInfoDao.findOne(goodId);
        GoodUpdateShowBo goodUpdateShowBo = new GoodUpdateShowBo();
        //商品id
        goodUpdateShowBo.setGoodsId(one.getfId());
        //商品名称
        goodUpdateShowBo.setGoodsName(one.getfName());
        if (one.getfCategoryIdTwo() != 0) {
            goodUpdateShowBo.setfCategoryId(one.getfCategoryIdTwo());
            //商品分类
            goodUpdateShowBo.setfCategoryName(categoryInfoDao.findOne(one.getfCategoryIdTwo()).getfName());
        } else {
            goodUpdateShowBo.setfCategoryId(one.getfCategoryIdOne());
            //商品分类
            goodUpdateShowBo.setfCategoryName(categoryInfoDao.findOne(one.getfCategoryIdOne()).getfName());
        }
        goodUpdateShowBo.setfUnitId(one.getfUnitId());
        //通过unitId查出unitName
        String unitName = unitInfoDao.findByFId(one.getfUnitId()).getfName();
        goodUpdateShowBo.setfUnitName(unitName);
        goodUpdateShowBo.setfStatus(one.getfStatus());
        goodUpdateShowBo.setFormatList(newList);
        goodUpdateShowBo.setfDesp(one.getfDesp());
        return goodUpdateShowBo;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void goodsAddOrUpdate(GoodAddOrUpdateBo goodAddOrUpdateBo,RespLoginPCBean respLoginPCBean) {
        TProductInfoEntity tProductInfoEntity = new TProductInfoEntity();
        //如果有id，则修改，没有id,则新增。
        //修改
        if (goodAddOrUpdateBo.getGoodsId() != null) {
            tProductInfoEntity = productInfoDao.findOne(goodAddOrUpdateBo.getGoodsId());
            tProductInfoEntity.setfId(goodAddOrUpdateBo.getGoodsId());
            tProductInfoEntity.setfUpdateTime(new Date());
            //修改商品时，商品名称重复，提示“商品名称不能重复”
            TProductInfoEntity tProductInfoEntity1 = productInfoDao.findByFNameAndFCompanyId(goodAddOrUpdateBo.getGoodsName(), respLoginPCBean.getfCompanyId());
            if (null != tProductInfoEntity1) {
                if (tProductInfoEntity1.getfId() != goodAddOrUpdateBo.getGoodsId()) {
                    throw new CommonRuntimeException(Status.GOODNAMEREPEAT);
                }
            }
        } else {
            //从session中获取companyId
            //新增
            tProductInfoEntity.setfCompanyId(respLoginPCBean.getfCompanyId());
            tProductInfoEntity.setfCreateTime(new Date());
            //新增商品时，商品名称重复，提示“商品名称不能重复”
            Long aLong = productInfoDao.countByFNameAndFCompanyId(goodAddOrUpdateBo.getGoodsName(), respLoginPCBean.getfCompanyId());
            if (aLong > 0) {
                throw new CommonRuntimeException(Status.GOODNAMEREPEAT);
            }
        }
        //商品名称
        tProductInfoEntity.setfName(goodAddOrUpdateBo.getGoodsName());
        //商品分类
        TCategoryInfoEntity one = categoryInfoDao.findOne(goodAddOrUpdateBo.getfCategoryId());
        if (one.getfParentId() == 0) {
            //如果传过来的是一级分类，则把二级分类设置成0
            tProductInfoEntity.setfCategoryIdOne(goodAddOrUpdateBo.getfCategoryId());
            tProductInfoEntity.setfCategoryIdTwo(0L);
        } else {
            tProductInfoEntity.setfCategoryIdTwo(goodAddOrUpdateBo.getfCategoryId());
            //如果传过来的是二级分类，则通过两级分类找到一级分类的id 存到t_ProductInfo表中
            long l = categoryInfoDao.findOne(goodAddOrUpdateBo.getfCategoryId()).getfParentId();
            tProductInfoEntity.setfCategoryIdOne(l);
        }
        //从session中获取Id
        tProductInfoEntity.setfOperate(respLoginPCBean.getfId());
        tProductInfoEntity.setfIsUnits("no");
        //计量单位
        tProductInfoEntity.setfUnitId(goodAddOrUpdateBo.getfUnitId());
        //商品状态
        tProductInfoEntity.setfStatus(goodAddOrUpdateBo.getfStatus());
        tProductInfoEntity.setfDesp(goodAddOrUpdateBo.getfDesp());
        tProductInfoEntity.setfSearchCondition("");

        productInfoDao.save(tProductInfoEntity);

        //商品规格
        String formatJson = goodAddOrUpdateBo.getFormatJson();
        //设置搜索关键字
        String searchCondition = goodAddOrUpdateBo.getGoodsName();
        List<ProductFormatBo> list = JSONObject.parseArray(formatJson, ProductFormatBo.class);
        for (int i = 0; i < list.size(); i++) {
            TProductFormatEntity tProductFormatEntity = new TProductFormatEntity();
            ProductFormatBo productFormatBo = list.get(i);
            if ("delete".equals(productFormatBo.getStatus())) {
                //该商品规格已经发生运单，不能删除
                Long aLong = transportOrderDetailDao.countByTProductFormatId(productFormatBo.getFormatId());
                if (aLong > 0) {
                    throw new CommonRuntimeException(Status.FORMARTDELETE);
                } else {
                    productFormatDao.delete(productFormatBo.getFormatId());
                }
            } else {
                //编辑
                if (productFormatBo.getFormatId() != null) {
                    TProductFormatEntity byFCompanyIdAndFCode = productFormatDao.findByFCompanyIdAndFCode(respLoginPCBean.getfCompanyId(), productFormatBo.getGoodsNo());
                    if (byFCompanyIdAndFCode != null) {
                        if (productFormatBo.getFormatId().longValue() != byFCompanyIdAndFCode.getfId()) {
                            throw new CommonRuntimeException(Status.GOODFORMATNORE);
                        }
                    }
                    tProductFormatEntity.setfId(productFormatBo.getFormatId());
                    tProductFormatEntity.setfCreateTime(productFormatDao.findOne(productFormatBo.getFormatId()).getfCreateTime());
                } else {                                                                     //新增
                    //新增或修改商品时，商品编码重复，提示“商品编码不能重复”
                    //companyId 从session 中获取
                    Long aLong = productFormatDao.countByFCodeAndFCompanyId(productFormatBo.getGoodsNo(), respLoginPCBean.getfCompanyId());
                    if (aLong > 0) {
                        throw new CommonRuntimeException(Status.GOODFORMATNORE);
                    }
                    tProductFormatEntity.setfCreateTime(new Date());
                }
                tProductFormatEntity.setfCode(productFormatBo.getGoodsNo());
                //从session 中获取。
                tProductFormatEntity.setfCompanyId(respLoginPCBean.getfCompanyId());
                tProductFormatEntity.setfName(productFormatBo.getFormatName());
                //从session 中获取
                tProductFormatEntity.setfOperate(respLoginPCBean.getfId());
                tProductFormatEntity.setfPic(productFormatBo.getPicMain());
                tProductFormatEntity.setfPrice(productFormatBo.getGoodsPrice());
                tProductFormatEntity.setfProductId(tProductInfoEntity.getfId());
                tProductFormatEntity.setfUpdateTime(new Date());
                searchCondition += productFormatBo.getGoodsNo() + productFormatBo.getFormatName();
                productFormatDao.save(tProductFormatEntity);
            }
        }
        tProductInfoEntity.setfSearchCondition(searchCondition);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void goodsDelete(Long goodsId) {
        int i = productInfoDao.deleteProductInfo(goodsId);
        if (i == 0) {
            throw new CommonRuntimeException(Status.FORMARTDELETE);
        }
        int y = productFormatDao.deleteProductFormat(goodsId);
        if (y == 0) {
            throw new CommonRuntimeException(Status.FORMARTDELETE);
        }
    }
}
