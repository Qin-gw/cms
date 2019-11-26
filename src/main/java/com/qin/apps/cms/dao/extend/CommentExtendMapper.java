package com.qin.apps.cms.dao.extend;

import com.qin.apps.cms.bean.Comment;
import com.qin.apps.cms.dao.CommentMapper;

import java.util.List;

public interface CommentExtendMapper extends CommentMapper {
    List<Comment> selectCommenByArticleId(Long articleId);
}

