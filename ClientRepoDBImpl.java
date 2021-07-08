package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Client;
import com.revature.util.JDBCConnect;


public class ClientRepoDBImpl implements ClientRepo {

	public static Connection conn = JDBCConnect.getConnection();
	
	@Override
	public Client getClient(int id) {
		String sql = "SELECT * FROM clients WHERE c_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return buildClient(rs);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> getAllClients() {
		String sql = "SELECT * FROM clients";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Client> clients = new ArrayList<Client>();
			
			while(rs.next()) {
				clients.add(buildClient(rs));
			}
			return clients;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client addClient(Client c) {
		String sql = "INSERT INTO clients VALUES (default,?,?,?) RETURNING *";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getBirthdate());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildClient(rs);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client updateClient(Client change) {
		String sql = "UPDATE clients SET first_name = ?, last_name = ?, birthdate = ? where c_id = ? RETURNING *";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getFirstName());
			ps.setString(2, change.getLastName());
			ps.setString(3, change.getBirthdate());
			ps.setInt(4, change.getId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				buildClient(rs);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client deleteClient(int id) {
		String sql = "DELETE FROM clients WHERE c_id = ? RETURNING *";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Client();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Client buildClient(ResultSet rs) throws SQLException {
		Client c = new Client();
		c.setId(rs.getInt("c_id"));
		c.setFirstName(rs.getString("first_name"));
		c.setLastName(rs.getString("last_name"));
		c.setBirthdate(rs.getString("birthdate"));
		
		return c;
	}

}
