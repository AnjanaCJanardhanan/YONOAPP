package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;

public interface ICustomerService {
	// deposit
	public void depositMoney(int id, int amt);

	// withdraw
	public void withdrawMoney(int id, int amt);

	// transfer money
	public void transferMoney(String accountno1, int accountno2, int amt);

	// display balance
	public int showBalance(int id);
}
