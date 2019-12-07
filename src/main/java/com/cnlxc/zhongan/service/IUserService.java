package com.cnlxc.zhongan.service;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.payload.SignupRequest;
import com.cnlxc.zhongan.pojo.User;

/**
 * Created by 82138 on 2019/12/7.
 */
public interface IUserService {
    ServerResponse singup(SignupRequest signupRequest);
}
