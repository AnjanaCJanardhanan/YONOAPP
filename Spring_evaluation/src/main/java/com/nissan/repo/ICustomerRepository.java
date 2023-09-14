package com.nissan.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance+?2 WHERE id=?1")
	public void depositMoney(int id, int amt);

	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance-?2 WHERE id=?1")
	public void withdrawMoney(int id, int amt);

	// TRANSFER
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance-?2 WHERE accountno=?1")
	public void withdraw(String accountno, int amt);

	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance+?2 WHERE id=?1")
	public void deposit(int accountno1, int amt);

	@Query("SELECT balance FROM com.nissan.model.Customer WHERE id=?1")
	public int showBalance(int id);

}
