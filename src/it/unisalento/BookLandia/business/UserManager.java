package it.unisalento.BookLandia.business;

import it.unisalento.BookLandia.model.Utente;

public class UserManager {

	private static UserManager instance;
	
	
	public static UserManager getInstance()
	{
		if(instance == null)
			instance = new UserManager();
		return instance;		
	}
	
	private Utente curUser; //utente correntemente loggato al sistema
	
	public UserManager()
	{
		curUser = new Utente();
	}
	
	public boolean LogIn(String utente, String password)
	{
		curUser.setUsername(utente);
		curUser.setPassword(password);
		boolean loginSuccess = curUser.login();
		return loginSuccess;	
	}
	
	
	
}
