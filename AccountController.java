package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Account;
import com.revature.services.AccountService;

import io.javalin.http.Handler;

public class AccountController {

	AccountService as;
	Gson gson = new Gson();

	public AccountController(AccountService as) {
		this.as = as;
	}

	public Handler getAllAccounts = (context) -> {
		String input = context.pathParam("id");
		int cid;
		try {
			cid = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			cid = -1;
		}
		List<Account> accounts = as.getAllAccounts(cid);
		context.result(accounts.toString());
	};

	public Handler getAccountById = (ctx) -> {
		String input = ctx.pathParam("id");
		String input2 = ctx.pathParam("id");
		int cid;
		int aid;
		try {
			cid = Integer.parseInt(input);
			aid = Integer.parseInt(input2);
		} catch(NumberFormatException e) {
			cid = -1;
			aid = -1;
		}
		Account a = as.getAccount(cid,aid);
		if (a != null) {
			ctx.result(gson.toJson(a));
		}else {
			ctx.status(404);
		}	
	};
	
	public Handler addAccount = (ctx) -> {
		String input = ctx.pathParam("id");
		int cid;
		try {
			cid = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			cid = -1;
		}
		Account a = gson.fromJson(ctx.body(), Account.class);
		a = as.addAccount(a,cid);
		if (a != null) {
			ctx.result(gson.toJson(a));
			ctx.status(201);
		}else {
			ctx.result("{ }");
		}	
	};
	
	public Handler updateAccount = (ctx) -> {
		String input = ctx.pathParam("id");
		String input2 = ctx.pathParam("id");
		int cid;
		int aid;
		try {
			cid = Integer.parseInt(input);
			aid = Integer.parseInt(input2);
		} catch(NumberFormatException e) {
			cid = -1;
			aid = -1;
		}
		Account a = gson.fromJson(ctx.body(), Account.class);
		
		a = as.updateAccount(a, cid, aid);
		if (a != null) {
			ctx.result(gson.toJson(a));
		}else {
			ctx.status(404);
		}	
	};
	
	public Handler deleteAccount = (ctx) -> {
		String input = ctx.pathParam("c_id");
		String input2 = ctx.pathParam("a_id");
		int cid;
		int aid;
		try {
			cid = Integer.parseInt(input);
			aid = Integer.parseInt(input2);
		} catch(NumberFormatException e) {
			cid = -1;
			aid = -1;
		}
		Account a = as.getAccount(cid,aid);
		if (a != null) {
			ctx.result(gson.toJson(a));
		}else {
			ctx.status(400);
		}	
	};
	
//	public Handler accountTransaction = (ctx) -> {
//		
//		String input = ctx.pathParam("id");
//		int id;
//		try {
//			id = Integer.parseInt(input);
//		} catch(NumberFormatException e) {
//			id = -1;
//		}
//		Account a = as.getAccount(id);
//		//CommandJson cj = gson.fromJson(ctx.body(), CommandJson.class);
//		if (a != null) {
//			ctx.result(gson.toJson(a));
//		}else {
//			ctx.status(400);
//		}	
//	};

	
}
