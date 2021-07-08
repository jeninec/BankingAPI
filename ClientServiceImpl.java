package com.revature.services;

import java.util.List;

import com.revature.models.Client;
import com.revature.repositories.ClientRepo;

public class ClientServiceImpl implements ClientService {

	public ClientRepo cr;
	
	
	public ClientServiceImpl(ClientRepo cr) {
		this.cr = cr;
	}

	@Override
	public Client getClient(int id) {
		return cr.getClient(id);
	}

	@Override
	public List<Client> getAllClients() {
		return cr.getAllClients();
	}

	@Override
	public Client addClient(Client c) {
		return cr.addClient(c);
	}

	@Override
	public Client updateClient(Client change) {
		return cr.updateClient(change);
	}

	@Override
	public Client deleteClient(int id) {
		return cr.deleteClient(id);
	}

}
