package brian.example.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import brian.example.boot.jpa.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByUserId(String userId);

}