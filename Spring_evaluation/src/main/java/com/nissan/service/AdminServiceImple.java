package com.nissan.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;

@Service
public class AdminServiceImple implements IAdminService {

	@Autowired
	private IAdminRepository customerrepo;
	@Autowired
	private Validation validation;

	public List<Customer> getCustomer() {

		return (List<Customer>) customerrepo.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		// Scanner scan = new Scanner(System.in);
		if (validation.isNameValid(customer.getCustomername())) {
			int a = (int) (Math.random() * 1000000000);
			customer.setAccountno(Integer.toString(a));
			int b = (int) (Math.random() * 10000);
			customer.setAtmpin(Double.toString(b));
			return customerrepo.save(customer);

		}

		return null;
	}

	public Customer getCustomer(int id) {

		return customerrepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for id" + id));
	}

	public void deleteCustomer(int id) {
		customerrepo.deleteCustomer(id);

	}

	public List<Customer> getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerrepo.findByCustomerByName(name);
	}

	public Customer updateCustomer(Customer customer) {

		return customerrepo.save(customer);
	}

}
