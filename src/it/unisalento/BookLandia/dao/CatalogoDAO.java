package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;
import it.unisalento.BookLandia.model.Autore;
import it.unisalento.BookLandia.model.Libro;

import java.util.Vector;

public class CatalogoDAO {
	String query = null;
	Vector<Libro> Libri = null;
	Vector<String[]> RisultatoQuery = null;
	private static CatalogoDAO instance;

	
	public static CatalogoDAO getInstance() {
		   if(instance == null)
			   instance = new CatalogoDAO();
		   return instance;
	   }
	
	//ritorna una matrice con i dati da rappresentare
	public CatalogoDAO()
	{
		query = "SELECT Titolo, Prezzo, ISBN,CopieDisponibili, Autori.Nome as Nome_Autore, Autori.Cognome as Cognome_Autore, Case_Editrici.Nome as Casa_Editrice"
				+ " from Libri INNER JOIN Generi INNER JOIN Case_Editrici INNER JOIN Autori where"
				+ "Case_Editrici_ID_Casa_Editrice =  ID_Casa_Editrice and Generi_Codice_Genere = Codice_Genere AND Autori_Codice_Autore = Codice_Autore;";
	}
	
	public Vector<Libro> getLibri()
	{
		Libri.clear();
		RisultatoQuery = DbConnection.getInstance().eseguiQuery(query);
		for(int z = 0; z < RisultatoQuery.size(); z++)
		{
			// to do: convertire stringhe in numeri e aggiungere lo scaffale alla query
			Libri.add(new Libro(RisultatoQuery.get(z)[0],RisultatoQuery.get(z)[1],RisultatoQuery.get(z)[2],RisultatoQuery.get(z)[3],RisultatoQuery.get(z)[4], RisultatoQuery.get(z)[5], RisultatoQuery.get(z)[6], RisultatoQuery.get(z)[7],"tmpScaffale",0,0));
		}
		return Libri;
	}
	
	//
}
