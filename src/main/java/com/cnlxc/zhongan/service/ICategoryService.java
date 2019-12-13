package com.cnlxc.zhongan.service;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.Category;
import java.util.List;
import java.util.Set;

/**
 * Created by 82138 on 2019/11/29.
 */
public interface ICategoryService {

    ServerResponse<List<Category>> getCategoryByParentId(int parentId);

    ServerResponse<Category> getCategoryById(int id);

    ServerResponse<Set<Category>> getCurCategoryAndChildCategory(int curId);

    //添加种类

    //移除种类
}
