package com.nissan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.repo.ICustomerRepository;

@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerrepo1;

	@Transactional
	// @Modifying
	// @Query("UPDATE com.nissan.model.Customer SET balance=balance+?2 WHERE
	// accountno=?1")
	public void depositMoney(int id, int amt) {
		customerrepo1.depositMoney(id, amt);
	}

	@Transactional
	// @Query("UPDATE com.nissan.model.Customer SET balance=balance-?2 WHERE
	// accountno=?1")
	public void withdrawMoney(int id, int amt) {
		customerrepo1.depositMoney(id, amt);
	}

	@Transactional
	public void transferMoney(String accountno1, int accountno2, int amt) {
		customerrepo1.withdraw(accountno1, amt);
		customerrepo1.deposit(accountno2, amt);

	}

	@Transactional
	public int showBalance(int id) {

		return customerrepo1.showBalance(id);

	}

}
