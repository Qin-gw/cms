package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.Category;
import com.qin.apps.cms.bean.CategoryExample;
import com.qin.apps.cms.dao.CategoryMapper;
import com.qin.apps.cms.service.ICategoryService;
import com.qin.apps.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void saveOrUpdateCategory(Category category)throws CustomerException{
        if (category.getId()!=null){
                categoryMapper.updateByPrimaryKey(category);
            }else {
                    CategoryExample example = new CategoryExample();
                    example.createCriteria().andNameEqualTo(category.getName());
                    List<Category> categories = categoryMapper.selectByExample(example);
                    if (categories.size()>0){
                        throw new CustomerException("栏目名不能重复");
                    }
                categoryMapper.insert(category);

            }
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void deleteCategoryById(List<Long> ids) {
        for (Long id:ids) {
            Category category = categoryMapper.selectByPrimaryKey(id);
            if (category==null){
                throw  new CustomerException("栏目不存在");
            }
            categoryMapper.deleteByPrimaryKey(id);
        }
    }
}
