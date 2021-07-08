package com.revature.repositories;

import java.util.List;

import com.revature.models.Client;

public interface ClientRepo {
	
	public Client getClient(int id);
	
	public List<Client> getAllClients();
	
	public Client addClient(Client c);
	
	public Client updateClient(Client change);
	
	public Client deleteClient(int id);
}
