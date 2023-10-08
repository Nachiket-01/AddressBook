package com.springboot.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from Spring Boot";
	}
	
	@GetMapping("/login/{username}/{password}")
	public String login(@PathVariable("username") String username, 
						@PathVariable("password") String password) {
		
		if(username.equals("admin") && password.equals("password")){
			return "Login succesful";
		}
		else {
			return "Invalid credentials";
		}
	}
	
	@GetMapping("/register/{firstName}/{lastName}/{password}")
	public UserData register(@PathVariable("firstName") String firstName,
						   @PathVariable("lastName") String lastName,
						   @PathVariable("password") String password) {
		
		UserData user = new UserData();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		//User user = new User(firstName,lastName,password);
		UserData savedUser = userService.registerUser(user);
		return savedUser;
	}
	
	
	@GetMapping("/getUser/{userId}")
	public UserData getUser(@PathVariable("userId") int userId){
		return userService.getUser(userId);
	}
	

}
