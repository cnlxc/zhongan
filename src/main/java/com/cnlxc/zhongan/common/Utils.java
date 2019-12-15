package com.cnlxc.zhongan.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 82138 on 2019/12/14.
 */
public class Utils {

    public static ConcurrentHashMap<String,String> CACHE = new ConcurrentHashMap(2>>100);
    public static BigDecimal CarInsuranceCalc(String city, String number, BigDecimal price, LocalDate date){
        // TODO: 2019/12/15

        return new BigDecimal("100");
    }

}
