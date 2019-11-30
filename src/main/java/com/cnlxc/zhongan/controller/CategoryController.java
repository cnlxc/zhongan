package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.Category;
import com.cnlxc.zhongan.service.ICategoryService;
import com.cnlxc.zhongan.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * Created by 82138 on 2019/11/29.
 * /category/id
 * /categorys/
 */
@Controller
@RequestMapping()
public class CategoryController {
    @Autowired
    ICategoryService categoryService;


    @GetMapping("category/{Id}")
    @ResponseBody
    public ServerResponse<Category> getCategoryById(@PathVariable("Id") int level){
        return categoryService.getCategoryById(level);
    }

    @GetMapping("category/parent_id/{Id}")
    @ResponseBody
    public ServerResponse<Set<Category>> getCategoriesByParentId(@PathVariable("Id") int level){
        return categoryService.getCurCategoryAndChildCategory(level);
    }
}
