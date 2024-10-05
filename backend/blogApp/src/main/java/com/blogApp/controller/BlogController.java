package com.blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.entities.Blog;
import com.blogApp.service.BlogService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	
	
	@PostMapping
	public Blog addBlog(@RequestBody Blog blog) {
		
		return blogService.createBlog(blog);
	}
	@GetMapping
	public List<Blog> getAllBlogs(){

		return blogService.getAllBlogs(); 
	}
	
	@GetMapping("/{id}")
	public Blog getBlog(@PathVariable int id){

		return blogService.getBlogById(id);
		
	}
	@PutMapping("/{id}")
	public Blog editBlog(@PathVariable int id, @RequestBody Blog blog) {
		
		
		return blogService.editBlog(blog, id);
	}
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		
		blogService.deleteBlogById(id);
		return "Blog was deleted";
	}
	
}
