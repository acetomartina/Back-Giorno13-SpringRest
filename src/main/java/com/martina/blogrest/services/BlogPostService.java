package com.martina.blogrest.services;

import com.martina.blogrest.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// questa classe contiene la logica e deve essere gestita come un Bean
@Service
public class BlogPostService {

    // lista che simula il database.
    private final List<BlogPost> blogPosts = new ArrayList<>();

    // variabile utilizzata per generare automaticamente gli id.
    private long nextId = 1;

    public List<BlogPost> findAll() {
        return blogPosts;
    }

    public BlogPost save(BlogPost blogPost) {

        blogPost.setId(nextId);

        // genera automaticamente la cover.
        blogPost.setCover("https://picsum.photos/200/300");

        blogPosts.add(blogPost);

        // Incrementa l'id per il prossimo BlogPost.
        nextId++;

        return blogPost;
    }
}