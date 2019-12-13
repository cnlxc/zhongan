package com.cnlxc.zhongan.service.impl;

import com.cnlxc.zhongan.common.Const;
import com.cnlxc.zhongan.dao.UserMapper;
import com.cnlxc.zhongan.payload.ResponseCode;
import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.payload.SigninRequest;
import com.cnlxc.zhongan.payload.SignupRequest;
import com.cnlxc.zhongan.pojo.User;
import com.cnlxc.zhongan.security.JwtTokenProvider;
import com.cnlxc.zhongan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Created by 82138 on 2019/12/7.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Override
    public ServerResponse singup(SignupRequest request) {

        if(userMapper.existsByEmail(request.getEmail() ) > 0)
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"邮箱已经被注册。");
        if(userMapper.existsByUsername(request.getUsername() ) > 0)
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(),"用户名已经被注册。");


        User user = new User(null,request.getUsername(),request.getPassword(),request.getEmail(),request.getPhone(),request.getQuestion(),request.getAnswer(),null,null,null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Const.Role.ROLE_USER);
        //成功插入
        if (userMapper.insert(user) != 0){
            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/users/{username}")
                    .buildAndExpand(request.getUsername()).toUri();

            return ServerResponse.createBySuccess(location);
        };
        return ServerResponse.createByErrorMessage("创建用户失败。");

    }


    public ServerResponse singin(SigninRequest signupRequest){
        System.out.println("getUsernameOrEmail " + signupRequest.getUsernameOrEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signupRequest.getUsernameOrEmail(),
                        signupRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ServerResponse.createBySuccess(Const.AUTH_TYPE + " " + jwt);
    }


}
