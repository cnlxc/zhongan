package com.cnlxc.zhongan.service;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.payload.SigninRequest;
import com.cnlxc.zhongan.payload.SignupRequest;
import com.cnlxc.zhongan.pojo.Person;
import com.cnlxc.zhongan.pojo.User;

/**
 * Created by 82138 on 2019/12/7.
 */
public interface IUserService {

    ServerResponse singup(SignupRequest signupRequest);

    ServerResponse singin(SigninRequest signupRequest);

    ServerResponse getUserById(long id);

    ServerResponse modifyInfoBy(User user);

    ServerResponse modifyInfoBy(Person person);

    ServerResponse forgetPasswordReset(String username,String password,String token);

    ServerResponse PasswordReset(String username,String password);

    ServerResponse getResetQuestion(String username);


    ServerResponse checkAnswerOfQuestion(String question,String answer,String username);

}
