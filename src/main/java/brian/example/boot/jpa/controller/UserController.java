package brian.example.boot.jpa.controller;

import brian.example.boot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	private UserService service;
	
	public UserController() {}
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping(value={"/users", "/users/index.html"})
	public String getAllUsers(Model model){

		model.addAttribute("users", service.getAllTestUsers());

		return "user/index";
	}
}
