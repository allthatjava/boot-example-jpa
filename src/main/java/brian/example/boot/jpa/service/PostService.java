package brian.example.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brian.example.boot.jpa.domain.Post;
import brian.example.boot.jpa.repository.PostRepository;

@Service
public class PostService{

	@Autowired
	private PostRepository repo;
	
	public Post getPost(int postId) {
		return repo.findByPostId(Integer.valueOf(postId));
	}
}
