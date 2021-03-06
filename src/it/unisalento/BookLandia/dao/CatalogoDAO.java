package it.unisalento.BookLandia.dao;

import it.unisalento.BookLandia.dbinterface.DbConnection;
import it.unisalento.BookLandia.model.Autore;
import it.unisalento.BookLandia.model.Libro;

import java.util.Vector;

public class CatalogoDAO {
	String query;
	Vector<Libro> Libri = new Vector<Libro>(10);
	Vector<String[]> RisultatoQuery = new Vector<String[]>(10);
	private static CatalogoDAO instance;

	
	public static CatalogoDAO getInstance() {
		   instance = null;
			   instance = new CatalogoDAO();
		   return instance;
	   }
	
	//ritorna una matrice con i dati da rappresentare
	public CatalogoDAO()
	{
		query = "SELECT ID, Titolo, Prezzo, ISBN, CopieDisponibili,"
				+ " Autori.Nome as Nome_Autore,"
				+ " Case_Editrici.Nome as Casa_Editrice, Generi.Nome, Settore from Libri"
				+ " INNER JOIN Generi ON Generi_Codice_Genere = Codice_Genere"
				+ " INNER JOIN Case_Editrici ON Case_Editrici_ID_Casa_Editrice = ID_Casa_Editrice"
				+ " INNER JOIN Autori ON Autori_Codice_Autore = Codice_Autore"
				+ " INNER JOIN scaffali ON ID_Scaffale = Scaffali_ID_Scaffale";
				
	}
	
	public Vector<Libro> getLibri()
	{
		Libri.clear();
		RisultatoQuery = DbConnection.getInstance().eseguiQuery(query);
		for(int z = 0; z < RisultatoQuery.size(); z++)
		{
			// to do: convertire stringhe in numeri e aggiungere lo scaffale alla query
			Libri.add(new Libro(Integer.parseInt(RisultatoQuery.get(z)[0]), RisultatoQuery.get(z)[1], Double.parseDouble(RisultatoQuery.get(z)[2]),RisultatoQuery.get(z)[3],Integer.parseInt(RisultatoQuery.get(z)[4]),RisultatoQuery.get(z)[5], RisultatoQuery.get(z)[6], RisultatoQuery.get(z)[7],RisultatoQuery.get(z)[8],0,0));
		}
		return Libri;
	}
	
	public int getNumeroLibri()
	{
		query = "SELECT COUNT(*) from Libri;";
		return Integer.parseInt((DbConnection.getInstance().eseguiQuery(query).get(0)[0]));
	}
}
