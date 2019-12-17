package brian.example.boot.jpa.controller;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.domain.Tag;
import brian.example.boot.jpa.domain.User;
import brian.example.boot.jpa.form.FormPost;
import brian.example.boot.jpa.service.PostService;
import brian.example.boot.jpa.service.TagService;
import brian.example.boot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class PostController {

	private PostService postService;
	private UserService userService;
	private TagService tagService;
	
	public PostController() {}
	
	@Autowired
	public PostController(PostService service, UserService userService, TagService tagService) {
		this.postService = service;
		this.userService = userService;
		this.tagService = tagService;
	}
	
	@GetMapping(value={ "", "/", "/posts", "/posts/index.html"})
	public String getAllPosts(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		
		return "post/index";
	}

	@GetMapping(value="/post/{postId}")
	public String getPost(Model model, @PathVariable("postId") Integer postId)
	{
		model.addAttribute("post", postService.getPost(postId));
		model.addAttribute( "users", userService.getAllUsers());

		return "post/post";
	}

	@GetMapping(value="/post")
	public String formPost(Model model){
		model.addAttribute( "users", userService.getAllUsers());
		model.addAttribute( "formPost", new FormPost());
		return "post/form";
	}

	@PostMapping(value="/post")
	public String insertPost(@ModelAttribute FormPost formPost){

		Post post = new Post();
		post.setSubject(formPost.getSubject());
		post.setContent(formPost.getContent());

		User user = userService.getUser(formPost.getUserId());
		post.setUserId(user.getUserId());
		post.setUser(user);

		// Save tags first
		if( formPost.getTag() != null ) {
			List<Tag> tagList = Stream.of(formPost.getTag())
					.map(tag -> tagService.save(new Tag(tag)))
					.collect(Collectors.toList());
			// Add tags to Post
			tagList.forEach(post.getTags()::add);
		}

		// Then save Post
		postService.save(post);

		return "redirect:/posts";
	}

	@PutMapping(value="/post")
	public String updatePost(@ModelAttribute FormPost postForm){

		Post post = postService.getPost(postForm.getPostId());
		post.setSubject(postForm.getSubject());
		post.setContent(postForm.getContent());

		User user = userService.getUser(postForm.getUserId());
		post.setUserId(user.getUserId());
		post.setUser(user);

		if( postForm.getTag() != null ) {
			// Delete Tags and Add
			post.getTags().forEach( tag -> tagService.delete(tag) );
			post.getTags().clear();

			// Save all tags
			List<Tag> tagList = Stream.of(postForm.getTag())
					.map(tag -> tagService.save(new Tag(tag)))
					.collect(Collectors.toList());
			// Add tags to Post
			tagList.forEach(post.getTags()::add);
		}

		postService.save(post);

		return "redirect:/posts";
	}

	@DeleteMapping(value="/post")
	public String deletePost(@ModelAttribute FormPost postForm){

		postService.deletePost(postForm.getPostId());

		return "redirect:/posts";
	}
}
