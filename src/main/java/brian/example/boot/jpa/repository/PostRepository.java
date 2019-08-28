package brian.example.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import brian.example.boot.jpa.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	
	public Post findByPostId(Integer postId);
}
