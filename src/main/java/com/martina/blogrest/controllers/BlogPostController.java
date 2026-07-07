package com.martina.blogrest.controllers;

import com.martina.blogrest.entities.BlogPost;
import com.martina.blogrest.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  gestisce richieste REST
@RestController

// tutti gli endpoint inizieranno con /blogPosts
@RequestMapping("/blogPosts")
public class BlogPostController {

    // Service che contiene la logica di business.
    @Autowired
    private BlogPostService blogPostService;

    // GET /blogPosts
    // Restituisce tutti i BlogPost
    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.findAll();
    }

    // Gestisce le richieste HTTP POST
    @PostMapping
    // @RequestBody converte automaticamente il JSON ricevuto nel body della richiesta in un oggetto BlogPost
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.save(blogPost);
    }
}