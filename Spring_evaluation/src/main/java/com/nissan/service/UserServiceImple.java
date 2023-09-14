package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repo.IUserRepository;
import com.nissan.util.JwtUtil;




@Service
public class UserServiceImple implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private JwtUtil jwtUtil;
	
	public APIResponse findUserByNameAndPasswordAdmin(String userName, String password) {
		User user = userRepository.findUserByNameAndPasswordAdmin(userName,  password);
		if(user==null) {
			apiResponse.setData("INVALID CREDENTIAlS");
			return apiResponse;
		}
		//credentials are correct then
		String token = jwtUtil.generateJwt(user);
		
		//storing more details and token
		Map<String, Object>data = new HashMap<String, Object>();
		data.put("ACCESSTOKEN", token);
		data.put("UserName", user.getUserName());
		
		apiResponse.setStatus(200);
		apiResponse.setData(data);
		
		return apiResponse;
			
		}
	public APIResponse findUserByNameAndPasswordCustomer(String userName, String password) {
		User user = userRepository.findUserByNameAndPasswordCustomer(userName,  password);
		if(user==null) {
			apiResponse.setData("INVALID CREDENTIAlS");
			return apiResponse;
		}
		//credentials are correct then
		String token = jwtUtil.generateJwt(user);
		
		//storing more details and token
		Map<String, Object>data = new HashMap<String, Object>();
		data.put("ACCESSTOKEN", token);
		data.put("UserName", user.getUserName());
		
		apiResponse.setStatus(200);
		apiResponse.setData(data);
		
		return apiResponse;
			
		}
	
	}


