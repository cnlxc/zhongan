package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.User;
import com.cnlxc.zhongan.security.UserPrincipal;
import com.cnlxc.zhongan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 82138 on 2019/12/8.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public ServerResponse<UserPrincipal> getCurrentUser(@AuthenticationPrincipal UserPrincipal currentUser) {
        //User  换成pojo

        return userService.getUserById(currentUser.getId());
    }

    @PostMapping("/user/{username}/reset_password")
    @PreAuthorize("hasRole('USER')")
    public ServerResponse resetPassword(@PathVariable("username") String username,@RequestParam("password") String password) {
        return userService.PasswordReset(username, password);
    }

    @GetMapping("/user/{username}/reset_password_question")
    public ServerResponse forgetPasswordGetQuestion(@PathVariable("username") String username) {
        return userService.getResetQuestion(username);
    }

    @PostMapping("/user/{username}/check_answer")
    public ServerResponse checkAnswer(@PathVariable("username") String username,@RequestParam("answer")String answer,@RequestParam("question")String question) {
        return  userService.checkAnswerOfQuestion(question,answer,username);
    }

    @PostMapping("/user/{username}/reset_password_by_token")
    public ServerResponse resetPasswordByToken(@PathVariable("username") String username,@RequestParam("password")String password,@RequestParam("token")String token) {
        return  userService.forgetPasswordReset(username,password,token);
    }
}