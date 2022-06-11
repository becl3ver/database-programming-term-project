package com.example.databasetermproject.controller;

import com.example.databasetermproject.domain.Post;
import com.example.databasetermproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts/new")
    public String submitNewPost(PostForm postForm, Model model)  {
        if(postForm.getTitle().equals("") || postForm.getContent().equals("")) {
            // 제목이나 내용이 비었기에 별도로 처리
        }
        Post post = new Post(postForm, 100);
        postService.submitNewPost(post);
        return "/db"; // 메인 화면으로 이동
    }

    @GetMapping(value = "/posts/new")
    public String createForm() {
        return "posts/post_form";
    }

    @GetMapping(value = "/posts/search")
    public String searchForm() {
        return "posts/post_search_form";
    }

    @PostMapping(value = "/posts/search")
    public String search(SearchForm searchForm, Model model) {
        String tmp = searchForm.getContent();
        if(tmp.length() == 1) {
            searchForm.setContent("");
        } else {
            searchForm.setCategory(tmp.substring(0, tmp.length() - 2));
        }
        List<Post> posts = postService.getPost(searchForm);

        for(Post post : posts) {
            System.out.println(post.getTitle());
        }

        model.addAttribute("posts", posts);
        return "/posts/post_list";
    }
}
