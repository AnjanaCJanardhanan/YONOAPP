package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/users/admin/{userName}&{password}")
	public ResponseEntity<APIResponse>findUserByNameAndPasswordAdmin(@PathVariable String userName, @PathVariable String password)
	{
		APIResponse apiResponse = userService.findUserByNameAndPasswordAdmin(userName,password);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	@GetMapping("/users/customer/{userName}&{password}")
	public ResponseEntity<APIResponse>findUserByNameAndPasswordCustomer(@PathVariable String userName, @PathVariable String password )
	{
		APIResponse apiResponse = userService.findUserByNameAndPasswordCustomer(userName,password);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
}
