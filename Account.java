package com.revature.models;

public class Account {
	
	private int id;
	private double balance;
	private String category;
	private boolean overdrawn;
	private long createdAt;
	
	//No-Args Constructor
	public Account() {
		super();
	}

	//All-Args Constructor
	public Account(int id, double balance, String category, boolean overdrawn, long createdAt) {
		super();
		this.id = id;
		this.balance = balance;
		this.category = category;
		this.overdrawn = overdrawn;
		this.createdAt = createdAt;
	}
	
	//ID-Less Constructor
	public Account(double balance, String category, boolean overdrawn, long createdAt) {
		super();
		this.balance = balance;
		this.category = category;
		this.overdrawn = overdrawn;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isOverdrawn() {
		return overdrawn;
	}

	public void setOverdrawn(boolean overdrawn) {
		this.overdrawn = overdrawn;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return category + " Account [id=" + id  + ", balance=" + balance + "]";
	}

}
