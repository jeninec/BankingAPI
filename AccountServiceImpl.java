package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.repositories.AccountRepo;

public class AccountServiceImpl implements AccountService {

	public AccountRepo ar;
	
	public AccountServiceImpl(AccountRepo ar) {
		this.ar = ar;
	}
	

	@Override
	public Account getAccount(int cid, int aid) {
		return ar.getAccount(cid, aid);
	}

	
	@Override
	public List<Account> getAllAccounts(int cid) {
		return ar.getAllAccounts(cid);
	}

	@Override
	public Account addAccount(Account a, int cid) {
		return ar.addAccount(a, cid);
	}


	@Override
	public Account updateAccount(Account change, int cid, int aid) {
		return ar.updateAccount(change, cid,aid);
	}


	@Override
	public Account deleteAccount(int aid) {
		return ar.deleteAccount(aid);
	}
	


}
