package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.bean.Category;
import com.qin.apps.cms.service.ICategoryService;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description ="栏目相关接口")
@RestController
@RequestMapping("/CategoryController")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @ApiOperation(value="保存或修改栏目",notes = "保存时候无需传递Id,如果传回Id后台会执行更新操作")
    @PostMapping("saveOrUpdateCategory")
    public Message saveOrUpdateCategory(Category category) {
        categoryService.saveOrUpdateCategory(category);
        return MessageUtil.success("更新成功！");
    }
    @ApiOperation("查询所有栏目")
    @GetMapping("findAllCategory")
    public Message findAllCategory(){
        List<Category> categories = categoryService.findAllCategory();
        return MessageUtil.success("查询成功！",categories);
    }
    @ApiOperation("通过ID删除栏目")
    @PostMapping("deleteCategoryById")
    public Message deleteCategoryById(@RequestBody List<Long> ids){
        categoryService.deleteCategoryById(ids);
        return MessageUtil.success("删除成功！");
    }
}
