package brian.example.boot.jpa.service;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService{

	private PostRepository repo;
	
	public PostService() {}
	
	@Autowired
	public PostService(PostRepository repo) {
		this.repo = repo;
	}
	
	public Post getPost(Integer postId) {
		return repo.findByPostId(postId);
	}
	
	public List<Post> getAllPosts() {
		List<Post> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		
		return list;
	}

	public Post save(Post post){
		return repo.save(post);
	}
}
