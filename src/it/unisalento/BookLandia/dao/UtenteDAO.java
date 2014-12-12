package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;
import java.util.Vector;

public class UtenteDAO {

	private static UtenteDAO instance;
	
	public static UtenteDAO getInstance()
	{
		if(instance == null)
			instance = new UtenteDAO();
		return instance;
	}
	
	public int login(String username, String password) {
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT ID_Utente FROM UTENTE WHERE username='"+username+"' AND password='"+password+"'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
}
