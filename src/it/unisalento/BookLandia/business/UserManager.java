package it.unisalento.BookLandia.business;

import it.unisalento.BookLandia.enums.UserType;
import it.unisalento.BookLandia.model.Utente;

public class UserManager {

	private static UserManager instance;
	
	
	private UserType utente_connesso;
	
	public UserType getUtente_connesso() {
		return utente_connesso;
	}

	public Utente getCurUser() {
		return curUser;
	}

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
	
	public UserType LogIn(String utente, String password)
	{
		curUser.setUsername(utente);
		curUser.setPassword(password);
		utente_connesso = curUser.login();
		return utente_connesso;	
	}

	public void LogOut() {
		curUser = new Utente();
		utente_connesso = UserType.NESSUNO;
	}
	
	
	
}
