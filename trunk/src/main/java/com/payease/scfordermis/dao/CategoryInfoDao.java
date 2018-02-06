package com.payease.scfordermis.dao;

import com.payease.scfordermis.entity.TCategoryInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryInfoDao extends JpaRepository<TCategoryInfoEntity,Long> {
    //通过f_level查出是几级菜单(按updatetime倒叙)
    List<TCategoryInfoEntity> findByFLevelAndFCompanyIdOrderByFUpdateTimeDesc(String level,Long companyId);
    //通过f_parent_id查出属于哪个一级菜单
    List<TCategoryInfoEntity> findByFParentIdOrderByFUpdateTimeDesc(Long parentId);
    //通过分类名称查询（用于判断是否有名字重复）
    Long countTCategoryInfoEntitiesByFNameAndFCompanyId(String categoryName,Long companyId);
    TCategoryInfoEntity findByFNameAndFCompanyId(String categoryName,Long companyId);
}
