package brian.example.boot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import brian.example.boot.jpa.domain.TestUser;

@Repository
public interface TestUserRepository extends CrudRepository<TestUser, Integer>{

	public TestUser findByUserId(String userId);

}