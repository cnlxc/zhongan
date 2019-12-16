package com.cnlxc.zhongan.service;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.Product;
import com.cnlxc.zhongan.pojo.ProductWithBLOBs;
import com.github.pagehelper.PageInfo;

/**
 * Created by 82138 on 2019/12/16.
 */
public interface IProductService {
    ServerResponse saveProduct(ProductWithBLOBs product);

    ServerResponse manageProductDetail(Integer productId);

    ServerResponse setProductStatus(Integer productId, Integer status);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, int pageNum, int pageSize);

    ServerResponse getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

    void transactionTest();
}
