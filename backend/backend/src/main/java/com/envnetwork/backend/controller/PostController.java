package com.envnetwork.backend.controller;

import com.envnetwork.model.Post;
import com.envnetwork.model.User;
import com.envnetwork.backend.service.PostService;
import com.envnetwork.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    // Create a new post
    @PostMapping("/{userId}")
    public Post createPost(@PathVariable Long userId, @RequestBody Post post) {
        User user = userService.getUserById(userId);
        return postService.createPost(user, post);
    }

    // Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // Get posts by user ID
    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        return postService.getPostsByUser(userId);
    }
}
