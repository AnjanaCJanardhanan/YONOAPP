package com.nissan.service;

import java.util.List;

import com.nissan.model.Customer;

public interface IAdminService {
	// list
	public List<Customer> getCustomer();

	// insert
	public Customer saveCustomer(Customer customer);

	// update by id
	public Customer getCustomer(int id);

	// delete
	public void deleteCustomer(int id);

	// search by name
	public List<Customer> getCustomerByName(String name);

	// update by id
	public Customer updateCustomer(Customer customer);

	// inner join
	// public List<CustomerDTO> getAllDtoCustomers();

}
