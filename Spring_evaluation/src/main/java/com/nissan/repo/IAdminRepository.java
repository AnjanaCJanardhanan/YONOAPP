package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;
@Repository
public interface IAdminRepository extends CrudRepository<Customer,Integer>{
	//Query
	@Query("from Customer WHERE customerName like %?1%")
	public List<Customer> findByCustomerByName(String name);
	
	@Query("UPDATE com.nissan.model.Customer SET is_active=false where id=?1")
	public void deleteCustomer(int id);

}
