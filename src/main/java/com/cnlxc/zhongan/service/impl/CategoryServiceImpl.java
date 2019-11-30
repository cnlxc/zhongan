package com.cnlxc.zhongan.service.impl;

import com.cnlxc.zhongan.dao.CategoryMapper;
import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.Category;
import com.cnlxc.zhongan.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 82138 on 2019/11/29.
 */
@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    CategoryMapper categoryMapper;

    public ServerResponse<List<Category>> getCategoryByParentId(int parentId){

        return ServerResponse.createBySuccess(categoryMapper.getCategoryByParentId(parentId));

    }

    public ServerResponse<Category> getCategoryById(int id){
        Category category = categoryMapper.selectByPrimaryKey(id);
        return Objects.isNull(category) ?  ServerResponse.createByErrorMessage("没有找到符合该ID的种类"):
                                            ServerResponse.createBySuccess(categoryMapper.selectByPrimaryKey(id)) ;

    }

    public ServerResponse<Set<Category>> getCurCategoryAndChildCategory(int curId){
        Set<Category> categories = new HashSet<>();
        popuateCategorySet(categories,curId);
        if(categories.isEmpty()){
            return ServerResponse.createByErrorMessage("没有找到符合该ID的种类");
        }
        return ServerResponse.createBySuccess(categories);
    }


    private void popuateCategorySet(Set categories,int curId){
        Category category = categoryMapper.selectByPrimaryKey(curId);
        if(!Objects.isNull(category) ) categories.add(category);
        List<Category> subCategories = categoryMapper.getCategoryByParentId(curId);
        for (Category c:
             subCategories) {
            popuateCategorySet(categories,c.getId());
        }



    }


}

