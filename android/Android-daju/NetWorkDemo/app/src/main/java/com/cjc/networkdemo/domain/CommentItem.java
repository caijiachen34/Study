package com.cjc.networkdemo.domain;

/**
 * Created by CC
 **/
public class CommentItem {

    /**
     * articleId : 234123
     * commentContent : 这是评论内容
     */

    private String articleId;
    private String commentContent;

    public String getArticleId() {
        return articleId;
    }

    public CommentItem(String articleId, String commentContent) {
        this.articleId = articleId;
        this.commentContent = commentContent;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
