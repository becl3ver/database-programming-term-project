package com.example.databasetermproject.controller;

import com.example.databasetermproject.domain.Post;
import com.example.databasetermproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewPostController {
    private final PostService postService;

    @Autowired
    public NewPostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts/new")
    public String submitNewPost(PostForm postForm, Model model)  {
        Post post = new Post(postForm, 100);
        postService.submitNewPost(post);
        return "/posts";
    }
}
