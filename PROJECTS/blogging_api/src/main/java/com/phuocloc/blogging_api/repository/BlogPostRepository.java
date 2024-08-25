package com.phuocloc.blogging_api.repository;

import com.phuocloc.blogging_api.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByTitleContainingOrContentContaining(String title, String content);
}
