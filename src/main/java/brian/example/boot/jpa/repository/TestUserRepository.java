package brian.example.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import brian.example.boot.jpa.domain.TestUser;

@Repository
//@Transactional(value = "hibernateEntityManager")
public interface TestUserRepository extends JpaRepository<TestUser, Integer>{

	public TestUser findByUserId(String userId);

}