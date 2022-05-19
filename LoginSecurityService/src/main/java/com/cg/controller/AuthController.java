package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.AutenticationRequest;
import com.cg.model.AuthenticationResponse;
import com.cg.model.UserModel;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;
import com.cg.utils.JwtUtils;
//controlls all REST API's
@RestController
public class AuthController {
	
	@Autowired //It is used for dependency injection
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils jwtutils;
	
	//To get
	@GetMapping("/dashboard")
    private String testingToken() {
        return "Welcome to DashBoard";
	}
	//to add details for signup
	@PostMapping("/signup")
	private ResponseEntity<?> subscribeClient(@RequestBody AutenticationRequest authenticationRequest){
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		UserModel  user = new UserModel();
		user.setUsername(username);
		user.setPassword(password);
		userRepository.save(user);
		try {
			userRepository.save(user);
		}catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error during client Registration:" + username));
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful Registration:" + username));
	
	
		
	}
	
//to add details for login 
	@PostMapping("/login")
	private ResponseEntity<?> authenticationClient(@RequestBody AutenticationRequest authenticationRequest){
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(Exception e){
			return ResponseEntity.ok(new AuthenticationResponse("Error during Client Login: "+ username));
			
		}
		UserDetails loadedUser =  userService.loadUserByUsername(username);
		String generatedToken = jwtutils.generateToken(loadedUser);
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		
	}
	
}
