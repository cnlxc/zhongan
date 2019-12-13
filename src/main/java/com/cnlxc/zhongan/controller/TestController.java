package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.dao_bak.MasterMapper;
import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.MasterKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 82138 on 2019/12/8.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    MasterMapper masterMapper;
    @GetMapping(value = "/exec")
    public ServerResponse exec(){
        return ServerResponse.createBySuccess(masterMapper.selectByPrimaryKey(new MasterKey("USER_ROLE","5","DUMMY","DUMMY","DUMMY","DUMMY")))
                ;
    }
}
