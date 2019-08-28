package brian.example.boot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.repository.PostRepository;

@Service
public class PostService{

	private PostRepository repo;
	
	public PostService() {}
	
	@Autowired
	public PostService(PostRepository repo) {
		this.repo = repo;
	}
	
	public Post getPost(int postId) {
		return repo.findByPostId(Integer.valueOf(postId));
	}
	
	public Post savePost(Post post) {
		
		return repo.save(post);
	}
	
	public void deletePost(Post post) {
		repo.delete(post);
	}

	public List<Post> getAllPosts() {
		List<Post> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		
		return list;
	}
}
