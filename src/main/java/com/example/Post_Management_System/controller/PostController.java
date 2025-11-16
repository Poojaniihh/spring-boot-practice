package com.example.Post_Management_System.controller;

import com.example.Post_Management_System.modal.Post;
import com.example.Post_Management_System.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")

    public String createPost(@Valid @RequestBody Post postDTO) {

        System.out.println("Title = " + postDTO.getTitle());
        System.out.println("Content = " + postDTO.getContent());
        System.out.println("Privacy = " + postDTO.getPrivacy());
        postService.addPost(postDTO);
        return postDTO.getTitle();
    }

    @GetMapping("/read")
    public List<Post> list() {
        return postService.findAll();
    }

    @GetMapping("/title/{title}")
    public Post findByTitle(@RequestParam(value = "title") String title) {
        return postService.findPostByTitle(title);
    }
    @PutMapping("/update")
    public void updatePost(@RequestBody Post postDTO){
        postService.updatePost(postDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        return postService.deletePost(id);
    }

}



