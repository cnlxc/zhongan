package com.cnlxc.zhongan.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by 82138 on 2019/12/7.
 */
@Data
public class SignupRequest {

    @NotBlank
    @Size(min = 4, max = 40)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(min=8,max=13)
    private String phone;


    @NotBlank
    private String question;

    @NotBlank
    private String answer;

}


