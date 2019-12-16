package com.cnlxc.zhongan.dao;

import com.cnlxc.zhongan.pojo.Product;
import com.cnlxc.zhongan.pojo.ProductWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductWithBLOBs record);

    int insertSelective(ProductWithBLOBs record);

    ProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    int updateByPrimaryKey(Product record);
    //ADD****************
    List<Product> selectList();

    List<Product> selectByName(@Param("product_name") String productName);


}