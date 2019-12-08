package com.cnlxc.zhongan.security;

import com.cnlxc.zhongan.common.Const;
import com.cnlxc.zhongan.dao.MasterMapper;
import com.cnlxc.zhongan.pojo.Master;
import com.cnlxc.zhongan.pojo.MasterKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
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
@Data
public class UserPrincipal implements UserDetails{

    //************  field *******************//
    private Long id;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user,List<GrantedAuthority> authorities){
        String userRoleId = String.valueOf(user.getRole());

        UserPrincipal userPrincipal = new UserPrincipal(Long.valueOf(user.getId()),user.getUsername(),user.getEmail(),user.getPassword(),authorities);

        return userPrincipal;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
    //注销账户功能添加时 追加判定
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //黑名单用户功能添加时 追加判定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
