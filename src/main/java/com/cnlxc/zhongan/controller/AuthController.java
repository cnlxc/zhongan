package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.payload.SigninRequest;
import com.cnlxc.zhongan.payload.SignupRequest;
import com.cnlxc.zhongan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/signin")
    public ServerResponse<?> signin(@Valid @RequestBody SigninRequest signinRequest){
        return userService.singin(signinRequest);
    }
}
