package com.test.client;
import com.example.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpStatus;

public class RestTemplateClient {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://localhost:8080";
        
        // Scenario 1: Successful GET request
        System.out.println("--- Scenario 1: Fetching user with ID 1 ---");
        String userUrl = baseUrl + "/users/{id}";
        long userId = 1;
        
        try {
            // Call the endpoint and map the JSON response directly to a User object
           // User user = restTemplate.getForObject(userUrl, User.class, userId);
        	User user = restTemplate.getForObject(userUrl, User.class, userId);
            if (user != null) {
                System.out.println("User fetched successfully:");
                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
                System.out.println("Email: " + user.getEmail());
            } else {
                System.out.println("Received a null user object from the server.");
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }

        System.out.println("\n-------------------------------------------");
        
	}
}
