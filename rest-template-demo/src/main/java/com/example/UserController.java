package com.example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	 @GetMapping("/users/{id}")
	    public User getUserById(@PathVariable long id) {
	        // In a real application, you would fetch this from a database
	        if (id == 1) {
	            return new User(1, "John Doe", "john.doe@example.com");
	        } else if (id == 2) {
	            return new User(2, "Jane Smith", "jane.smith@example.com");
	        } else {
	            // This would normally return a 404 Not Found status
	            // For this simple example, we return null to demonstrate
	            // getForObject behavior with a null response.
	            return null;
	        }
	    }
}
