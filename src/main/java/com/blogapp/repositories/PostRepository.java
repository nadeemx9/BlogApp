package com.blogapp.repositories;

import com.blogapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(int id);
    List<Post> findByCategory(int id);

}
