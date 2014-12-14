package it.unisalento.BookLandia.business;

import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.model.Utente;

public class UserManager {

	private static UserManager instance;
	
	
	private UserType utente_connesso;
	
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
		utente_connesso = UserType.NESSUNO;
	}
	
	public int LogIn(String utente, String password)
	{
		curUser.setUsername(utente);
		curUser.setPassword(password);
		UserType type = curUser.login();
		return type;	
	}
	
	
	
}
