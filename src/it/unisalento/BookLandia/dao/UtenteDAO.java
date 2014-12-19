package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;
import it.unisalento.BookLandia.enums.UserType;

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
	
	public String getName(int ID)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Nome FROM UTENTE WHERE ID_Utente='"+ID+"'");
		return risultato.get(0)[0].toString(); //metodo richiamato da utente dopo il login, si ha già la sicurezza che l'id esista
	}
	
	public String getSurname(int ID)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Cognome FROM UTENTE WHERE ID_Utente='"+ID+"'");
		return risultato.get(0)[0].toString(); //metodo richiamato da utente dopo il login, si ha già la sicurezza che l'id esista
	
	}
	
	public UserType getType(int ID)
	{
		//ritorna il tipo dell'utente che ha un certo ID, se non esiste ritorna None
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT ID_Cliente FROM cliente WHERE ID_Cliente='"+ID+"'");
		if(risultato.size() != 0) return UserType.CLIENTE;
		
		risultato = DbConnection.getInstance().eseguiQuery("SELECT ID_Addetto_Vendite FROM addetti_vendite WHERE ID_Addetto_Vendite='"+ID+"'");
		if(risultato.size() != 0) return UserType.VENDITE;
		
		risultato = DbConnection.getInstance().eseguiQuery("SELECT ID_Addetto_Scaffali FROM addetti_scaffali WHERE ID_Addetto_Scaffali='"+ID+"'");
		if(risultato.size() != 0) return UserType.SCAFFALI;
		
		return UserType.NESSUNO;
	}
}
