package com.cnlxc.zhongan.service.impl;

import com.cnlxc.zhongan.common.Const;
import com.cnlxc.zhongan.common.Utils;
import com.cnlxc.zhongan.dao.PersonMapper;
import com.cnlxc.zhongan.dao.UserMapper;
import com.cnlxc.zhongan.payload.ResponseCode;
import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.payload.SigninRequest;
import com.cnlxc.zhongan.payload.SignupRequest;
import com.cnlxc.zhongan.pojo.Person;
import com.cnlxc.zhongan.pojo.User;
import com.cnlxc.zhongan.security.JwtTokenProvider;
import com.cnlxc.zhongan.service.IUserService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.Objects;

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
    @Autowired
    PersonMapper personMapper;

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

    public ServerResponse getUserById(long id){
        return ServerResponse.createBySuccess(userMapper.selectByPrimaryKey((int)id));

    }
    //一级信息修改
    public ServerResponse modifyInfoBy(User user){
        try{
            userMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            return ServerResponse.createByErrorMessage("用户信息修改失败。");
        }
        return ServerResponse.createBySuccess("用户主信息修改完成。");
    }
    //``二
    //级信息修改
    public ServerResponse modifyInfoBy(Person person){
        try{
            personMapper.updateByPrimaryKeySelective(person);
        }catch (Exception e){
            return ServerResponse.createByErrorMessage("用户信息修改失败。");
        }

        return ServerResponse.createBySuccess("用户二级信息修改完成。");
    }
    //HashMap 临时缓存
    public ServerResponse forgetPasswordReset(String username,String password,String token){
        if(!StringUtils.hasText(token))
            return  ServerResponse.createByErrorMessage("请输入校验token");

        String cacheToken = Utils.CACHE.get(username);
        if(Objects.isNull(cacheToken) ){
            return ServerResponse.createByErrorMessage("TOKEN校验失败1");
        }
        if(!cacheToken.equals(token) ) {
            return ServerResponse.createByErrorMessage("TOKEN校验失败2");
        }
        User user = new User().builder().id(userMapper.selectByUsernameOrEmail(username).getId())
                .password( passwordEncoder.encode(password))
                .updateTime(new Date())
                .build();
        //id and password
        userMapper.updateByPrimaryKeySelective(user);
        Utils.CACHE.remove(username);
        return ServerResponse.createBySuccess("更新密码成功");
    }

    public ServerResponse PasswordReset(String username,String password){
        User user = new User().builder().id(userMapper.selectByUsernameOrEmail(username).getId())
                .password( passwordEncoder.encode(password))
                .updateTime(new Date())
                .build();
        userMapper.updateByPrimaryKeySelective(user);
        return ServerResponse.createBySuccess("更新密码成功");
    }

    public ServerResponse getResetQuestion(String username){
        User user =userMapper.selectByUsernameOrEmail(username);
        if(Objects.isNull(user)) return ServerResponse.createByErrorMessage("用户不存在");
        return ServerResponse.createBySuccess(user.getQuestion());
    }

    public ServerResponse checkAnswerOfQuestion(String question,String answer,String username){

        User user =userMapper.selectByUsernameOrEmail(username);
        if(Objects.isNull(user)) return ServerResponse.createByErrorMessage("用户不存在");
        if(!question.equals(user.getQuestion()) || !answer.equals(user.getAnswer())){
            return ServerResponse.createByErrorMessage("问题校验失败");
        }

        ObjectIdGenerators.UUIDGenerator generator =new ObjectIdGenerators.UUIDGenerator();
        String token = generator.generateId(username + question).toString();
        Utils.CACHE.put(username,token);
        return ServerResponse.createBySuccess(token);
    }

}
