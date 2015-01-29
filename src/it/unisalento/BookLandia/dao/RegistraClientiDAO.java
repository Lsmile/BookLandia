package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class RegistraClientiDAO {

	public static void RegistraClienteDAO()
	{
		
	}
	
	public static void RegistraCliente(String Username, String Password, String Nome, String Cognome, String Codice_Fiscale)
	{
		String query = "INSERT INTO utente (`Username`, `Password`, `Nome`, `Cognome`, `ID_Utente`, `CodiceFiscale`) VALUES ('" + Username + "','" + Password + "','" + Nome + "','" + Cognome + "', '0' , '" + Codice_Fiscale + "')";
		DbConnection.getInstance().eseguiAggiornamento(query);
		int ID = Integer.parseInt(DbConnection.getInstance().eseguiQuery("SELECT ID_UTENTE from utente where CodiceFiscale LIKE '" + Codice_Fiscale+ "'").get(0)[0]);
		query = "Insert into Cliente VALUES ('" + ID + "');"; 
		DbConnection.getInstance().eseguiAggiornamento(query);
		
	}
	
	public static Boolean checkUsername(String Username){
		String query = "SELECT COUNT(*) from utente where Username LIKE '" + Username +"';";
		if (Integer.parseInt(DbConnection.getInstance().eseguiQuery(query).get(0)[0]) != 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public static Boolean CheckCodiceFiscale(String CodiceFiscale)
	{
		String query = "SELECT COUNT(*) from utente where CodiceFiscale LIKE '" + CodiceFiscale +"'";
		if (Integer.parseInt(DbConnection.getInstance().eseguiQuery(query).get(0)[0]) != 0)
		{
			return true;
		}
		else
			return false;
	}
}
