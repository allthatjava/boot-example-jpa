package brian.boot.template.jpa.repository;

import brian.boot.template.jpa.domain.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Integer>{


}