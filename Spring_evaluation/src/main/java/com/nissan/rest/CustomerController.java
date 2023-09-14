package com.nissan.rest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtil;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private ICustomerService customerservice1;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private JwtUtil jwtUtil;

	// deposit money
	@PutMapping("/customer/deposit/{id}&{amt}")
	public void depositMoney(@PathVariable int id, @PathVariable int amt,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {

		jwtUtil.verifyCustomer(auth);
		customerservice1.depositMoney(id, amt);
	}

	@PutMapping("/customer/transfer/{accountno1}&{accountno2}&{amt}")
	public void transferMoney(@PathVariable String accountno1, @PathVariable int accountno2, @PathVariable int amt,
			@RequestHeader(value = "authorization", defaultValue = "") String auth) throws AccessDeniedException {

		jwtUtil.verifyCustomer(auth);
		customerservice1.transferMoney(accountno1, accountno2, amt);
	}

	@GetMapping("/customer/showbalance/{id}")
	public int showBalance(@PathVariable int id, @RequestHeader(value = "authorization", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtil.verifyCustomer(auth);
		return customerservice1.showBalance(id);
	}
}
