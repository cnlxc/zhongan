package com.cnlxc.zhongan.security;

import com.cnlxc.zhongan.common.Const;
import com.cnlxc.zhongan.dao.MasterMapper;
import com.cnlxc.zhongan.pojo.Master;
import com.cnlxc.zhongan.pojo.MasterKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import com.cnlxc.zhongan.pojo.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 82138 on 2019/11/30.
 */
@AllArgsConstructor
@Component
public class UserPrincipal implements UserDetails{

    @Autowired
    static MasterMapper masterMapper;
    //************  field *******************//
    private Long id;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user){
        String userRoleId = String.valueOf(user.getRole());
        Master master = masterMapper.selectByPrimaryKey(new MasterKey(userRoleId,Const.DUMMY,Const.DUMMY,Const.DUMMY,Const.DUMMY,Const.DUMMY));
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(master.getVal1()));

        UserPrincipal userPrincipal = new UserPrincipal(Long.valueOf(user.getId()),user.getUsername(),user.getEmail(),user.getPassword(),authorities);

        return userPrincipal;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrincipal that = (UserPrincipal) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
