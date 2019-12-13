package com.cnlxc.zhongan.dao;

import com.cnlxc.zhongan.pojo.Person;
import com.cnlxc.zhongan.pojo.PersonKey;

public interface PersonMapper {
    int deleteByPrimaryKey(PersonKey key);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(PersonKey key);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}