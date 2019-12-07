package brian.example.boot.jpa.controller;

import brian.example.boot.jpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
