package brian.example.boot.jpa.controller;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.form.PostForm;
import brian.example.boot.jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

	private PostService service;
	
	public PostController() {}
	
	@Autowired
	public PostController(PostService service) {
		this.service = service;
	}
	
	@GetMapping(value={"/posts", "/posts/index.html"})
	public String getAllPosts(Model model) {
		model.addAttribute("posts", service.getAllPosts());
		
		return "post/index";
	}

	@GetMapping(value="/post/{postId}")
	public String getPost(Model model, @PathVariable("postId") Integer postId)
	{
		model.addAttribute("post", service.getPost(postId));

		return "post/post";
	}

	@GetMapping(value="/post")
	public String formPost(){
		return "post/form";
	}

	@PostMapping(value="/post")
	public String insertPost(@ModelAttribute PostForm postForm){

		Post post = new Post();
		post.setSubject(postForm.getSubject());
		post.setContent(postForm.getContent());
		post.setUserId(postForm.getUser());

		service.save(post);

		return "redirect:/posts";
	}

	@PutMapping(value="/post")
	public String updatePost(@ModelAttribute PostForm postForm){

		Post post = service.getPost(postForm.getPostId());
		post.setSubject(postForm.getSubject());
		post.setContent(postForm.getContent());

		service.save(post);

		return "redirect:/posts";
	}
}
