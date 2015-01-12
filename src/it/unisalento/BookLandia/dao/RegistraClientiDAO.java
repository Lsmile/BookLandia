package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class RegistraClientiDAO {

	public static void RegistraClienteDAO()
	{
		
	}
	
	public static void RegistraCliente(String Username, String Password, String Nome, String Cognome, String Codice_Fiscale)
	{
		String query = "INSERT INTO utente (`Username`, `Password`, `Nome`, `Cognome`, `ID_Utente`, `CodiceFiscale`) VALUES ('" + Username + ",'," + Password + ",'," + Nome + ",'," + Cognome + ", '0' , ' " + Codice_Fiscale + "')";
		DbConnection.getInstance().eseguiAggiornamento(query);
		int ID = Integer.parseInt(DbConnection.getInstance().eseguiQuery("SELECT ID_UTENTE from utente where CodiceFiscale =" + Codice_Fiscale).get(0)[0]);
		query = "Insert into Cliente VALUES ('" + ID + "');"; 
		DbConnection.getInstance().eseguiAggiornamento(query);
		
	}
}
