package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.User;
import com.cnlxc.zhongan.security.UserPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 82138 on 2019/12/8.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public ServerResponse<UserPrincipal> getCurrentUser(@AuthenticationPrincipal UserPrincipal currentUser) {
        //User  换成pojo
        return ServerResponse.createBySuccess(currentUser);
    }
}
