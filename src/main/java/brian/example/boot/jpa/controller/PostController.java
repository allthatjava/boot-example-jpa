package brian.example.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.domain.TestUser;
import brian.example.boot.jpa.service.PostService;

@RestController
public class PostController {

	private PostService service;
	
	public PostController() {}
	
	@Autowired
	public PostController(PostService service) {
		this.service = service;
	}
	
	@GetMapping(value="/posts")
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> list = service.getAllPosts();
		
		return new ResponseEntity<>( list, HttpStatus.OK );
	}
	
	@GetMapping(value="/post/{postId}")
	public ResponseEntity<Post> getPost(@PathVariable("postId") int postId)
	{
		Post post = service.getPost(postId);
		
		return new ResponseEntity<>( post, HttpStatus.OK );
	}
	
	@PostMapping(value="/post")
	public ResponseEntity<Post> addPost(@RequestBody Post post)
	{
		post.setTestUser(new TestUser(post.getUserId()));
		post = service.savePost(post);
		
		return new ResponseEntity<>( post, HttpStatus.OK );
	}
	
	@DeleteMapping(value="/post/{postId}")
	public ResponseEntity<Post> deletePost(@PathVariable("postId") int postId)
	{
		Post post = new Post();
		post.setPostId(postId);
		service.deletePost(post);
		
		return new ResponseEntity<>( post, HttpStatus.OK );
	}
	
	@PutMapping(value="/post/{postId}")
	public ResponseEntity<Post>  updatePost(@RequestBody Post post)
	{
		post.setTestUser(new TestUser(post.getUserId()));
		post = service.savePost(post);
		
		return new ResponseEntity<>( post, HttpStatus.OK );
	} 
}
