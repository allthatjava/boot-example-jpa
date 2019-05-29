package brian.template.boot.jpa.repository.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import brian.template.boot.jpa.domain.hibernate.Post;

@Repository
@Transactional(value = "hibernateEntitsyManager")
public interface PostRepository extends JpaRepository<Post, Integer>{
}
