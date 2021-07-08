package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.util.JDBCConnect;

public class AccountRepoDBImpl implements AccountRepo {

	public static Connection conn = JDBCConnect.getConnection();
	
	@Override
	public Account getAccount(int cid, int aid) {
		// Aiming for this line below
		//String sql = "SELECT * FROM accounts WHERE client_id = ? AND a_id = ?";
		String sql = "SELECT * FROM accounts WHERE a_id = ?";
		try {
			//Set up Prepared Statement
			PreparedStatement ps = conn.prepareStatement(sql);
			//Fill in place holders
			//ps.setInt(1, cid);
			ps.setInt(1, aid);
			//Execute Query, store the results
			ResultSet rs = ps.executeQuery();
			//Extract results out of Result Set
			if(rs.next()) {
				return buildAccount(rs);
			}
			
		}catch(SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccounts(int cid) {
		String sql = "SELECT * FROM accounts WHERE client_id = ?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			
			List<Account> accounts = new ArrayList<Account>();
			
			while(rs.next()) {
				accounts.add(buildAccount(rs));
			}
			return accounts;
			
		}catch(SQLException e) { 
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Account addAccount(Account a, int cid) {
		String sql = "INSERT INTO accounts VALUES (default,?,?,default,default,?) RETURNING *";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Fill in values for place holders: ?
			ps.setDouble(1, a.getBalance());
			ps.setString(2, a.getCategory());
			ps.setInt(3, cid);
			
			//Execute Query, store the results
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return buildAccount(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account updateAccount(Account change, int cid, int aid) {
		//UPDATE TABLE_NAME SET C1 = V1, ... , CN = VN WHERE X = Y
		String sql = "UPDATE accounts SET balance = ?, category = ?, client_id = ? WHERE a_id = ? RETURNING *";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, change.getBalance());
			ps.setString(2, change.getCategory());
			ps.setInt(3, cid);
			ps.setInt(4, aid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//update the account
				return buildAccount(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public Account deleteAccount(int aid) {
		String sql = "DELETE account FROM accounts WHERE a_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//remove the account
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	

	private Account buildAccount(ResultSet rs) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("a_id"));
		a.setBalance(rs.getDouble("balance"));
		a.setCategory(rs.getString("category"));
		a.setOverdrawn(rs.getBoolean("overdrawn"));
		a.setCreatedAt(rs.getLong("created_at"));
		return a;
	}

	

}
