package brian.example.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brian.example.boot.jpa.domain.TestUser;
import brian.example.boot.jpa.service.TestUserService;

@RestController
public class TestUserController {

	private TestUserService service;
	
	public TestUserController() {}
	
	@Autowired
	public TestUserController(TestUserService service) {
		this.service = service;
	}
	
	@GetMapping("/testusers")
	public List<TestUser> getAllTestUsers(){
		return service.getAllTestUsers();
	}
}
