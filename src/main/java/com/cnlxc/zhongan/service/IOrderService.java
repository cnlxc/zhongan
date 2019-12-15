package com.cnlxc.zhongan.service;

import com.cnlxc.zhongan.payload.ServerResponse;

import java.util.Map;

/**
 * Created by 82138 on 2019/12/13.
 */
public interface IOrderService {
    //查询
    //修改（包括无效化订单）

    //创建
    //
   //一般模型
    ServerResponse buy(Long orderNo, Integer userId, String path);

    ServerResponse aliCallBack(Map<String, String> params);

    ServerResponse queryOrderStatus(Integer userId, long orderNo);

    ServerResponse createOrder(Integer userId);

    ServerResponse<String> cancel(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse getOrderDetial(Integer userId, Long orderNo);

    ServerResponse getOrderList(Integer userId, int pageNum, int PageSize);

    ServerResponse manageList(int pageNum, int pageSize);

    ServerResponse manageDetail(Long orderNo);

    ServerResponse manageSearch(Long orderNo, int pageNum, int pageSize);


    //hour个小时未付款的订单关闭
    void closeOrder(int hour);
}
