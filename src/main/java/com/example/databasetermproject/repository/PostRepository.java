package com.example.databasetermproject.repository;

import com.example.databasetermproject.domain.Post;

public interface PostRepository {
    Post save(Post post);
}