package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.Category;
import com.qin.apps.cms.utils.CustomerException;

import java.util.List;

public interface ICategoryService {
void saveOrUpdateCategory(Category category) throws CustomerException;
List<Category> findAllCategory();
void deleteCategoryById(List<Long> ids)throws CustomerException;
}
