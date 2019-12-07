package com.cnlxc.zhongan.dao;

import com.cnlxc.zhongan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    int existsByUsername(@Param("username") String username);

    int existsByEmail(@Param("email") String email);
}