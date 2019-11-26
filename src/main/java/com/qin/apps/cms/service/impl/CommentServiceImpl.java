package com.qin.apps.cms.service.impl;

import com.qin.apps.cms.bean.Comment;
import com.qin.apps.cms.dao.CommentMapper;
import com.qin.apps.cms.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void saveComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void deleteBatchComment(List<Long> ids) {
        for (Long id:ids) {
            commentMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void deleteComment(Long id) {
        commentMapper.deleteByPrimaryKey(id);
    }


}
