package com.qin.apps.cms.bean.extend;

import com.qin.apps.cms.bean.Category;

import java.util.List;

public class CategoryExtend extends Category {
    private List<CategoryExtend> categoryExtends;

    public List<CategoryExtend> getCategoryExtends() {
        return categoryExtends;
    }

    public void setCategoryExtends(List<CategoryExtend> categoryExtends) {
        this.categoryExtends = categoryExtends;
    }
}
