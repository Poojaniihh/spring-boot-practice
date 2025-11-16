package com.example.Post_Management_System.service;


import com.example.Post_Management_System.modal.Post;
import com.example.Post_Management_System.repository.PostRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {
    @Resource
    private PostRepository postRepository;

    public void addPost(Post post){
        postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void updatePost(Post postDTO) {
        postRepository.save(postDTO);
    }

    public String deletePost(Integer id) {
          postRepository.deleteById(id);
          return "Post deleted";

    }

    public Post findPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }
}
