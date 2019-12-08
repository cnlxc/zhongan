package com.cnlxc.zhongan.common;

/**
 * Created by 82138 on 2019/11/30.
 */

public class Const {
    public static final String DUMMY = "DUMMY"; //MASTER table dummy key
    public static final String MASTER_KEY_USER_ROLE = "USER_ROLE";

    public static final String AUTH_TYPE = "Bearer";


    public interface Role{
        public static final  int ROLE_USER = 5;
        public static final  int ROLE_VIP1 = 4;
        public static final  int ROLE_VIP3 = 2;
        public static final  int ROLE_ADMIN = 1;

    }
}
