package com.teammcgrath.dicegame;

import com.teammcgrath.dicegame.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

    @Autowired
    PostService postService;

    public PostService getPostService() { return postService; }

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/post")
    public Post getPost() {
        return postService.getPostById();
    }
}
