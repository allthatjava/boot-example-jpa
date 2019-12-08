package brian.example.boot.jpa.service;

import brian.example.boot.jpa.domain.User;
import brian.example.boot.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	private UserRepository repo;
	
	public UserService() {}
	
	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		repo.findAll().forEach(users::add);
		
		return users;
	}

	public User getUser(String userId){
		return repo.findByUserId(userId);
	}
}
