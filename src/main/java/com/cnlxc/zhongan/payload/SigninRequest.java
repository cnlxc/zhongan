package com.cnlxc.zhongan.payload;

import lombok.Data;

/**
 * Created by 82138 on 2019/12/8.
 */
@Data
public class SigninRequest {

    private String usernameOrEmail;

    private String password;
}
