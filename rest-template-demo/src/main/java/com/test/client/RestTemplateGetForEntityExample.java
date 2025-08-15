package com.test.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.User;

public class RestTemplateGetForEntityExample {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "http://localhost:8080/users/{id}";
		 Long userId = 1L;
		 
		 try {
			 ResponseEntity<User> responseEntity = restTemplate.getForEntity(apiUrl, User.class, userId);
			 if (responseEntity.getStatusCode().is2xxSuccessful()) {
	                // Get the User object from the response body
	                User user = responseEntity.getBody();

	                // Print the user details
	                System.out.println("Successfully retrieved user details:");
	                System.out.println("HTTP Status Code: " + responseEntity.getStatusCode());
	                System.out.println("User Object: " + user);

	                // You can also access headers from the response
	                System.out.println("Content-Type Header: " + responseEntity.getHeaders().getContentType());
	            } else {
	                System.err.println("Failed to retrieve user details. HTTP Status Code: " + responseEntity.getStatusCode());
	            }
		 }catch (Exception e) {
	            System.err.println("An error occurred while making the request: " + e.getMessage());
	            e.printStackTrace();
	        }

	}

}
