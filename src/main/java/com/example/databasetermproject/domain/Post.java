package com.example.databasetermproject.domain;

import com.example.databasetermproject.controller.PostForm;

public class Post {
    private int postId;
    private int uid;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    private String postTitle;
    private String postContent;

    public Post(PostForm postForm, int uid)  {
        this.uid = uid;
        postTitle = postForm.getPostTitle();
        postContent = postForm.getPostContent();
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
