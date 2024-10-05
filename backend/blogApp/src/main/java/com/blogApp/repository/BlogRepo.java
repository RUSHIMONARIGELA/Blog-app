package com.blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.entities.Blog;

public interface BlogRepo extends JpaRepository<Blog, Integer>{

}
