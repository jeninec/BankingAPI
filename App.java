package com.revature.app;

import com.revature.controllers.AccountController;
import com.revature.controllers.ClientController;
import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoDBImpl;
import com.revature.repositories.ClientRepo;
import com.revature.repositories.ClientRepoDBImpl;
import com.revature.services.AccountService;
import com.revature.services.AccountServiceImpl;
import com.revature.services.ClientService;
import com.revature.services.ClientServiceImpl;

import io.javalin.Javalin;

//import java.io.javalin;



/*
 * JUnit test for DAOs and Services
 */

public class App {

	public static void main(String[] args) {
		// Establish our Javalin Object
		Javalin app = Javalin.create();
		
		//Establish the Routes/Endpoints Javalin will manage
		establishRoutes(app);

		// Run Javalin
		app.start(7000);
	}

	private static void establishRoutes(Javalin app) {
		// Establish a route to the 'landing' page.
		app.get("/", (ctx) -> ctx.result("This is Our Banking App Home Page!"));
		//app.get("/hello", (ctx) -> ctx.result("Hello World!"));

		AccountRepo ar = new AccountRepoDBImpl();
		AccountService as = new AccountServiceImpl(ar);
		AccountController ac = new AccountController(as);
		
		ClientRepo cr = new ClientRepoDBImpl();
		ClientService cs = new ClientServiceImpl(cr);
		ClientController cc = new ClientController(cs);
		
		//GET Methods
		app.get("/clients", cc.getAllClients);
		app.get("/clients/:id", cc.getClientById);
		
		app.get("/clients/:id/accounts", ac.getAllAccounts);
		app.get("/clients/:id/accounts/:id", ac.getAccountById);
		
		//POST Methods
		app.post("/clients/:id/accounts", ac.addAccount);
		app.post("/clients", cc.addClient);
		
		//PUT Methods
		app.put("/clients/:id/accounts/:id", ac.updateAccount);
		app.put("/clients/:id", cc.updateClient);
		
		//DELETE Methods
		app.delete("/clients/:id/accounts/:id", ac.deleteAccount);
		app.delete("/clients/:id", cc.deleteClient);
//		
		
		//PATCH Methods
//		app.patch("/accounts/:id", ac.accountTransaction);
		
	}

}
