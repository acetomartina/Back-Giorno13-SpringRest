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

    @GetMapping("/{id}")
    // @PathVariable prende l'id dall'URL
    public BlogPost getBlogPostById(@PathVariable Long id) {
        return blogPostService.findById(id);
    }

    // Gestisce le richieste HTTP PUT.
    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable Long id,
                                   @RequestBody BlogPost blogPost) {

        return blogPostService.update(id, blogPost);
    }

    // Gestisce le richieste HTTP DELETE.
    @DeleteMapping("/{id}")
    public String deleteBlogPost(@PathVariable Long id) {

        boolean deleted = blogPostService.delete(id);

        if (deleted) {
            return "BlogPost eliminato con successo!";
        }

        return "BlogPost non trovato!";
    }
}