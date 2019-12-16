package com.cnlxc.zhongan.service.impl;

import com.cnlxc.zhongan.dao.ProductMapper;
import com.cnlxc.zhongan.payload.ResponseCode;
import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.Product;
import com.cnlxc.zhongan.pojo.ProductWithBLOBs;
import com.cnlxc.zhongan.service.IProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by 82138 on 2019/12/16.
 */
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public ServerResponse saveProduct(ProductWithBLOBs product) {
        if (product == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGALARGUMENT.getCode(),ResponseCode.ILLEGALARGUMENT.getDesc());
        }
        if(product.getId() != null) {
            int resultCount = productMapper.updateByPrimaryKey(product);
            if(resultCount > 0) {
                return ServerResponse.createBySuccess("更新产品成功");
            }
            return ServerResponse.createByErrorMessage("更新产品失败");
        }else{
            int resultCount = productMapper.insert(product);
            if (resultCount > 0){
                return ServerResponse.createBySuccess("新增产品成功");
            }
            return ServerResponse.createByErrorMessage("新增产品失败");
        }

    }

    @Override
    public ServerResponse manageProductDetail(Integer productId) {
        if (productId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGALARGUMENT.getCode(),ResponseCode.ILLEGALARGUMENT.getDesc());
        }
        ProductWithBLOBs product = productMapper.selectByPrimaryKey(productId);
        if(Objects.isNull(product)){
            return  ServerResponse.createByErrorMessage("ID" + productId +  "的产品不存在。");
        }
        return ServerResponse.createBySuccess(product);
    }

    @Override
    public ServerResponse setProductStatus(Integer productId, Integer status) {
        if(productId == null || status == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGALARGUMENT.getCode(),ResponseCode.ILLEGALARGUMENT.getDesc());
        }
        ProductWithBLOBs product = new ProductWithBLOBs();
        product.setId(productId);
        product.setStatus(status);
        product.setUpdateTime(new Date());
        int resultCount = productMapper.updateByPrimaryKeySelective(product);
        if(resultCount > 0) {
            return ServerResponse.createBySuccess("修改产品状态成功");
        }
        return ServerResponse.createByErrorMessage("修改产品状态失败");
    }

    @Override
    public ServerResponse<PageInfo> getProductList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);//pagehelper使用方法 https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
        /*跟在startPage后面的第一个查询会被分页*/
        List<Product> productList = productMapper.selectList();

        PageInfo pageResult = new PageInfo(productList);
        pageResult.setList(productList);
        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse<PageInfo> searchProduct(String productName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products =  productMapper.selectByName("%" + productName + "%");
        if(Objects.isNull(products)){return ServerResponse.createByErrorMessage("没有找到类似产品。");}
        PageInfo pageResult = new PageInfo(products);
        pageResult.setList(products);
        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse getProductDetail(Integer productId) {
        return null;
    }

    @Override
    public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy) {
        return null;
    }

    @Override
    public void transactionTest() {

    }
}
