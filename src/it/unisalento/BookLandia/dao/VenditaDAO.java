package it.unisalento.BookLandia.dao;

import java.util.Vector;

import it.unisalento.BookLandia.dbinterface.DbConnection;

public class VenditaDAO {
private static VenditaDAO instance;
	
	public static VenditaDAO getInstance()
	{
		if(instance == null)
		{
			instance = new VenditaDAO();
		}
		return instance;
	}
	
	public Vector<String[]> getLibro(int ID)
	{
		String query = "SELECT Titolo, autori.Nome, case_editrici.Nome, generi.Nome, ISBN, Prezzo "
					+ "FROM libri INNER JOIN autori ON Autori_Codice_Autore = Codice_Autore "
					+ "INNER JOIN case_Editrici ON Case_Editrici_ID_Casa_Editrice = ID_Casa_Editrice "
					+ "INNER JOIN generi ON Generi_Codice_Genere = Codice_Genere "
					+ "WHERE ID =" + ID + ";";
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery(query);
		return risultato;
	}
	
}
