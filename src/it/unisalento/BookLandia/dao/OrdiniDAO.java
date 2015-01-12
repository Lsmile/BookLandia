package it.unisalento.BookLandia.dao;

import java.util.Vector;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class OrdiniDAO {
	
	public static int getNumeroRecord()
	{
		String query = "SELECT COUNT(*) from ordinazioni";
		return Integer.parseInt(DbConnection.getInstance().eseguiQuery(query).get(0)[0]);
	}
	
	public static Vector<String[]> getOrdinazioni()
	{
		String query = "SELECT ID_Ordinazione, libri.Titolo, autori.Nome, libri.Prezzo, "
						+ "utente.Nome, utente.Cognome, Data_Inserimento, Data_Completato, Data_Consegna "
						+ " INNER JOIN coseh";
		return DbConnection.getInstance().eseguiQuery(query);
		
	}
	
}
