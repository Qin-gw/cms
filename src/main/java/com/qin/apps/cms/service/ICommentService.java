package com.qin.apps.cms.service;

import com.qin.apps.cms.bean.Comment;

import java.util.List;

public interface ICommentService {
    void saveComment(Comment comment);
    void deleteBatchComment(List<Long> ids);
    void deleteComment(Long id);
}
