package com.blogApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.entities.Blog;
import com.blogApp.repository.BlogRepo;

@Service
public class BlogService {
 
	@Autowired
	BlogRepo blogrepo;
	
	public Blog createBlog(Blog blog) {
		return blogrepo.save(blog);
	}
	
	public List<Blog> getAllBlogs(){
		return blogrepo.findAll();
	}
	
	public Blog getBlogById(int id) {
		return blogrepo.findById(id).orElseThrow(()-> new RuntimeException("Blog is not found with ") );
	}
	
	public Blog editBlog(Blog blog,int id) {
		
		blog.setId(id);
		return blogrepo.save(blog);
		
	}
	
	public void deleteBlogById(int id) {
		blogrepo.deleteById(id);
	}

}
