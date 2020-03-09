package com.coretheorylife.modules.purchaser.dao;

import com.coretheorylife.modules.common.dao.BaseMapper;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavorite;
import com.coretheorylife.modules.purchaser.entity.TPurchaserFavoriteExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TPurchaserFavoriteMapper extends BaseMapper<TPurchaserFavorite, TPurchaserFavoriteExample> {
    int countByExample(TPurchaserFavoriteExample example);

    int deleteByExample(TPurchaserFavoriteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPurchaserFavorite record);

    int insertSelective(TPurchaserFavorite record);

    List<TPurchaserFavorite> selectByExample(TPurchaserFavoriteExample example);

    TPurchaserFavorite selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPurchaserFavorite record, @Param("example") TPurchaserFavoriteExample example);

    int updateByExample(@Param("record") TPurchaserFavorite record, @Param("example") TPurchaserFavoriteExample example);

    int updateByPrimaryKeySelective(TPurchaserFavorite record);

    int updateByPrimaryKey(TPurchaserFavorite record);
}