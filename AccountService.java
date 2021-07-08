package com.revature.services;

import java.util.List;

import com.revature.models.Account;

public interface AccountService {

	public Account getAccount(int cid, int aid);
	
	public List<Account> getAllAccounts(int cid);
	
	public Account addAccount(Account a, int cid);
	
	public Account updateAccount(Account change, int cid, int aid);
	
	public Account deleteAccount(int aid);
	
}
