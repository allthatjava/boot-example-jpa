package brian.example.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import brian.example.boot.jpa.domain.Post;

@Repository
//@Transactional(value = "hibernateEntityManager")
public interface PostRepository extends CrudRepository<Post, Integer>{
	
	public Post findByPostId(Integer postId);
}
