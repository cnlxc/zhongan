package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.dao.UserMapper;
import com.cnlxc.zhongan.payload.ResponseCode;
import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.payload.SignupRequest;
import com.cnlxc.zhongan.pojo.User;
import com.cnlxc.zhongan.security.JwtTokenProvider;
import com.cnlxc.zhongan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by 82138 on 2019/12/7.
 */
@RestController()
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    IUserService userService;

    @PostMapping("/signup")
    public ServerResponse<?> signup(@Valid @RequestBody SignupRequest signupRequest){
        return userService.singup(signupRequest);

    }
}