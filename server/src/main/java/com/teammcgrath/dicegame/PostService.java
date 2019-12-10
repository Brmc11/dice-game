package com.teammcgrath.dicegame;

import com.teammcgrath.dicegame.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {

    private RestTemplate restTemplate;

    private String getUrl = "https://jsonplaceholder.typicode.com/posts/1";

    @Autowired
    public PostService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Post getPostById() {
        return restTemplate.getForObject(getUrl, Post.class);
    }

}
