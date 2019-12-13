package com.cnlxc.zhongan.security;

import com.cnlxc.zhongan.common.Const;
import com.cnlxc.zhongan.dao_bak.MasterMapper;
import com.cnlxc.zhongan.dao_bak.UserMapper;
import com.cnlxc.zhongan.exception.ResourceNotFoundException;
import com.cnlxc.zhongan.pojo.Master;
import com.cnlxc.zhongan.pojo.MasterKey;
import org.springframework.beans.factory.annotation.Autowired;
import com.cnlxc.zhongan.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by 82138 on 2019/11/30.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserMapper userMapper;

    @Autowired
    MasterMapper masterMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("yanzhengyonghuming " + s);
        User user =userMapper.selectByUsernameOrEmail(s);
        if(Objects.isNull(user)) throw new UsernameNotFoundException("用户" + s +"没有找到");

        String roleId = String.valueOf(user.getRole() );

        return UserPrincipal.create(user,getAuthority(roleId));
    }

    public UserDetails loadByUserId(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if(Objects.isNull(user)) throw new ResourceNotFoundException("User","id",userId);

        String roleId = String.valueOf(user.getRole() );
        return UserPrincipal.create(user,getAuthority(roleId));
    }


    private List<GrantedAuthority> getAuthority(String roleId){
        //权限
        Master master = masterMapper.selectByPrimaryKey(
                new MasterKey(Const.MASTER_KEY_USER_ROLE,roleId,Const.DUMMY,Const.DUMMY,Const.DUMMY,Const.DUMMY)
        );
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(master.getVal1()));
        return authorities;
    }
}
