package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;

import com.nissan.model.Customer;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtil;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private IAdminService customerservice;
	
	@Autowired
	private APIResponse apiResponse;
	
	@GetMapping("/admin")
	public List<Customer> getCustomer(@RequestHeader(value="authorization",defaultValue="") String auth) throws AccessDeniedException{
		jwtUtil.verifyAdmin(auth);
		return customerservice.getCustomer();
	}
		//search by id
	@GetMapping("/admin/{id}")
	public Customer getCustomer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="") String auth) throws AccessDeniedException
	{
		jwtUtil.verifyAdmin(auth);
			return customerservice.getCustomer(id);
	}
	//add
	@PostMapping("/admin")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="") String auth) throws AccessDeniedException{
		System.out.println("hiii");
		if(customerservice.saveCustomer(customer)==null){
			apiResponse.setData("Name can have only alphabets");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");
			
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		jwtUtil.verifyAdmin(auth);
		apiResponse.setData("CUSTOMER ADDED SUCCESSFULLY");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	//update Customer 
	@PutMapping("/admin/{id}")
	public ResponseEntity<APIResponse> updateCustomer(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="") String auth) throws AccessDeniedException
	{
		jwtUtil.verifyAdmin(auth);
		apiResponse.setData("EMPLOYEE UPDATED SUCCESSFULLY");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	//delete customer
	@DeleteMapping("/admin/{id}")
	public void deleteCustomer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="") String auth) throws AccessDeniedException
	{
		jwtUtil.verifyAdmin(auth);
		customerservice.deleteCustomer(id);
	}
	
	//search by name
	@GetMapping("/admin/search/{name}")
	public List<Customer> getAllCustomersByName(@PathVariable String name,@RequestHeader(value="authorization",defaultValue="") String auth) throws AccessDeniedException
	{
		jwtUtil.verifyAdmin(auth);
		return customerservice.getCustomerByName(name);
	}
}
	

