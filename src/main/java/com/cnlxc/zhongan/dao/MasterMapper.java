package com.cnlxc.zhongan.dao;

import com.cnlxc.zhongan.pojo.Master;
import com.cnlxc.zhongan.pojo.MasterKey;

public interface MasterMapper {
    int deleteByPrimaryKey(MasterKey key);

    int insert(Master record);

    int insertSelective(Master record);

    Master selectByPrimaryKey(MasterKey key);

    int updateByPrimaryKeySelective(Master record);

    int updateByPrimaryKey(Master record);
}