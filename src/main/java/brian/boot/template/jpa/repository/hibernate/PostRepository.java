package brian.boot.template.jpa.repository.hibernate;

import brian.boot.template.jpa.domain.hibernate.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
}
