package brian.example.boot.jpa.repository;

import brian.example.boot.jpa.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByUserId(String userId);

}