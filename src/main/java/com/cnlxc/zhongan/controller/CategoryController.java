package com.cnlxc.zhongan.controller;

import com.cnlxc.zhongan.payload.ServerResponse;
import com.cnlxc.zhongan.pojo.Category;
import com.cnlxc.zhongan.service.ICategoryService;
import com.cnlxc.zhongan.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by 82138 on 2019/11/29.
 * /category/id
 * /categorys/
 */
@RestController()
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;


    @GetMapping("/{Id}")
    public ServerResponse<Category> getCategoryById(@PathVariable("Id") int level){
        return categoryService.getCategoryById(level);
    }

    @GetMapping("/parent_id/{Id}")
    public ServerResponse<Set<Category>> getCategoriesByParentId(@PathVariable("Id") int level){
        return categoryService.getCurCategoryAndChildCategory(level);
    }
}
