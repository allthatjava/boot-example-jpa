package brian.boot.template.jpa.repository.hibernate;

import brian.boot.template.jpa.domain.hibernate.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "hibernateEntityManager")
public interface TestUserRepository extends JpaRepository<TestUser, Integer>{


}