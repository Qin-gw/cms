package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.Article;
import com.qin.apps.cms.bean.ArticleExample;
import com.qin.apps.cms.bean.extend.ArticleExtend;
import com.qin.apps.cms.dao.extend.ArticleExtendMapper;
import com.qin.apps.cms.service.IArticleService;
import com.qin.apps.cms.utils.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleExtendMapper articleMapper;
    @Override
    public void saveOrUpdateArticle(Article article) throws CustomerException {

        if (article.getId() != null) {
            articleMapper.updateByPrimaryKey(article);
        } else {
            ArticleExample example= new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> list = articleMapper.selectByExample(example);
            if (list.size()>0){
                throw new CustomerException("文章标题不能重复");
            }
            article.setStatus(ArticleExtend.STATUS_UNCHECH);
            article.setThumpDown(0L);
            article.setThumpUp(0L);
            article.setPublishTime(new Date().getTime());
            articleMapper.insert(article);
        }
    }
    @Override
    public List<Article> findAllArticle() {
        return articleMapper.selectByExample(new ArticleExample());
    }
    @Override
    public List<ArticleExtend> cascadeFindAllArticle() {

        return articleMapper.cascadeFindAllArticle();
    }
    @Override
    public ArticleExtend findArticleById(Long id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public void deleteArticleById(List<Long> ids) throws CustomerException{
        for (Long id:ids) {
            Article article = articleMapper.selectByPrimaryKey(id);
            if (article==null){
                throw new CustomerException("文章不存在！");
            }
            articleMapper.deleteByPrimaryKey(id);
        }
    }
}
