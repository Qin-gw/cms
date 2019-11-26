package com.qin.apps.cms.web.controller;

import com.qin.apps.cms.bean.Comment;
import com.qin.apps.cms.service.ICommentService;
import com.qin.apps.cms.utils.Message;
import com.qin.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description ="评论相关接口")
@RestController
@RequestMapping("/CommentController")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @ApiOperation("添加评论")
    @PostMapping("saveComment")
    public Message saveComment(Comment comment){
        commentService.saveComment(comment);
        return MessageUtil.success("评论成功！");
    }
    @ApiOperation("删除单条评论")
    @GetMapping("deleteComment")
    public Message deleteComment(Long id){
        commentService.deleteComment(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation("批量删除评论")
    @PostMapping("deleteBatchComment")
    public Message deleteBatchComment(List<Long> ids){
        commentService.deleteBatchComment(ids);
        return MessageUtil.success("删除成功");
    }
}
