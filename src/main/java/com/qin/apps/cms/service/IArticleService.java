package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.Article;
import com.qin.apps.cms.bean.extend.ArticleExtend;
import com.qin.apps.cms.utils.CustomerException;

import java.util.List;

public interface IArticleService {
    void saveOrUpdateArticle(Article article) throws CustomerException;
    List<Article> findAllArticle();
    List<ArticleExtend> cascadeFindAllArticle();
    ArticleExtend findArticleById(Long id);
    void deleteArticleById(List<Long> ids) throws CustomerException;
}
