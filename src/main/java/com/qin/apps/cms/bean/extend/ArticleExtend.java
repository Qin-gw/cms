package com.qin.apps.cms.bean.extend;

import com.qin.apps.cms.bean.Article;
import com.qin.apps.cms.bean.Category;
import com.qin.apps.cms.bean.Comment;
import com.qin.apps.cms.bean.User;

import java.util.List;

public class ArticleExtend extends Article {
    public static final String STATUS_UNCHECH = "未审核";
    public static final String STATUS_CHECH_PASS = "审核通过";
    public static final String STATUS_CHECH_NOPASS = "审核未通过";
    private Category category;
    private User User;
    private List<Comment> comments;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public com.qin.apps.cms.bean.User getUser() {
        return User;
    }

    public void setUser(com.qin.apps.cms.bean.User user) {
        User = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
