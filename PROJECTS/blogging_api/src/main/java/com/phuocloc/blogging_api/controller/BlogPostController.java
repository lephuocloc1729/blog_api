package com.phuocloc.blogging_api.controller;

import com.phuocloc.blogging_api.model.BlogPost;
import com.phuocloc.blogging_api.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost){
        BlogPost createdBlogPost = blogPostService.createBlogPost(blogPost);
        return ResponseEntity.ok(createdBlogPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable long id, @RequestBody BlogPost blogPost){
        BlogPost updatedBlogPost = blogPostService.updateBlogPost(id, blogPost);
        if (updatedBlogPost != null){
            return ResponseEntity.ok(updatedBlogPost);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable long id){
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPost(@PathVariable long id){
        BlogPost blogPost = blogPostService.getBlogPost(id);
        if (blogPost != null){
            return ResponseEntity.ok(blogPost);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts(){
        return ResponseEntity.ok(blogPostService.getAllBlogPosts());
    }

    @GetMapping("/search")
    public ResponseEntity<List<BlogPost>> searchBlogPost(@RequestParam String searchTerm){
        return ResponseEntity.ok(blogPostService.searchBlogPost(searchTerm));
    }
}
