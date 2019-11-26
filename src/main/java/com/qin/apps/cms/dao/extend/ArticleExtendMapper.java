package com.qin.apps.cms.dao.extend;

import com.qin.apps.cms.bean.extend.ArticleExtend;
import com.qin.apps.cms.dao.ArticleMapper;

import java.util.List;

public interface ArticleExtendMapper extends ArticleMapper {
    List<ArticleExtend> cascadeFindAllArticle();
    ArticleExtend findArticleById(Long id);
}
