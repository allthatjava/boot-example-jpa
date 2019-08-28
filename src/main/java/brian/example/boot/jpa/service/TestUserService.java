package brian.example.boot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brian.example.boot.jpa.domain.TestUser;
import brian.example.boot.jpa.repository.TestUserRepository;

@Service
public class TestUserService {

	private TestUserRepository repo;
	
	public TestUserService() {}
	
	@Autowired
	public TestUserService(TestUserRepository repo) {
		this.repo = repo;
	}
	
	public List<TestUser> getAllTestUsers(){
		List<TestUser> users = new ArrayList<>();
		repo.findAll().forEach(users::add);
		
		return users;
	}
}
