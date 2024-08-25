package com.phuocloc.blogging_api.service;

import com.phuocloc.blogging_api.model.BlogPost;
import com.phuocloc.blogging_api.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createBlogPost(BlogPost blogPost){
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public BlogPost updateBlogPost(long id, BlogPost blogPost){
        Optional<BlogPost> existingBlogPost = blogPostRepository.findById(id);
        if (existingBlogPost.isPresent()){
            BlogPost toUpdatePost = existingBlogPost.get();
            toUpdatePost.setTitle(blogPost.getTitle());
            toUpdatePost.setContent(blogPost.getContent());
            toUpdatePost.setTags(blogPost.getTags());
            toUpdatePost.setCategory(blogPost.getCategory());
            toUpdatePost.setUpdatedAt(LocalDateTime.now());
            return blogPostRepository.save(toUpdatePost);
        }
        return null;
    }

    public void deleteBlogPost(long id){
        blogPostRepository.deleteById(id);
    }

    public BlogPost getBlogPost(long id){
        return blogPostRepository.findById(id).orElse(null);
    }

    public List<BlogPost> getAllBlogPosts(){
        return blogPostRepository.findAll();
    }

    public List<BlogPost> searchBlogPost(String searchTerm){
        return blogPostRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

}
