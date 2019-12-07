package com.cnlxc.zhongan.security;

import com.cnlxc.zhongan.dao.UserMapper;
import com.cnlxc.zhongan.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.cnlxc.zhongan.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by 82138 on 2019/11/30.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =userMapper.selectByUsernameOrEmail(s);
        if(Objects.isNull(user)) throw new UsernameNotFoundException("用户" + s +"没有找到");

        return UserPrincipal.create(user);
    }

    public UserDetails loadByUserId(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if(Objects.isNull(user)) throw new ResourceNotFoundException("User","id",userId);
        return UserPrincipal.create(user);
    }
}
