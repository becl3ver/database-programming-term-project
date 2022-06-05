package com.example.databasetermproject.service;

import com.example.databasetermproject.domain.Post;;
import com.example.databasetermproject.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void submitNewPost(Post Post) {
        postRepository.save(Post);
    }
}
